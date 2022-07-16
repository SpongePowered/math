/*
 * This file is part of Math (template generator), licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.gradle.math.templates;

import net.kyori.mammoth.Configurable;
import org.gradle.api.Action;
import org.gradle.api.GradleException;
import org.gradle.api.InvalidUserDataException;
import org.gradle.api.Named;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.NamedDomainObjectSet;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.Optional;
import org.snakeyaml.engine.v2.api.Load;
import org.snakeyaml.engine.v2.api.LoadSettings;
import org.snakeyaml.engine.v2.exceptions.YamlEngineException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

/**
 * A directory of templates.
 *
 * <p>While it's perfectly possible to </p>
 *
 *
 */
public abstract class TemplateSet implements Named {

    // shared
    private final ConfigurableFileCollection dataFiles;
    private final MapProperty<String, Object> properties;
    private final NamedDomainObjectContainer<Variant> variants;
    private final Property<String> header;
    private final String name;

    @Inject
    public TemplateSet(final String name, final ObjectFactory objects) {
        this.name = name;
        this.dataFiles = objects.fileCollection();
        this.properties = objects.mapProperty(String.class, Object.class);
        this.variants = objects.domainObjectContainer(Variant.class);
        this.header = objects.property(String.class);
    }

    @Input
    @Override
    public String getName() {
        return this.name;
    }

    // global properties

    /**
     * A collection of data files in YAML format.
     *
     * @return the data file collection
     */
    @InputFiles
    public ConfigurableFileCollection getDataFiles() { // if there are variants, reads per-variant data from a list under `variants`
        return this.dataFiles;
    }

    /**
     * Runtime-defined properties.
     *
     * <p>These properties will override anything in the data files.</p>
     *
     * @return the properties properties
     */
    @Nested
    public MapProperty<String, Object> getProperties() {
        return this.properties;
    }

    /**
     * A literal header to insert at the top of generated source files.
     *
     * <p>This property is optional.</p>
     *
     * @return the header
     */
    @Input
    @Optional
    public Property<String> getHeader() {
        return this.header;
    }

    // variant

    @Nested
    public NamedDomainObjectContainer<Variant> getVariants() {
        return this.variants;
    }

    public void variants(final String... variants) {
        for (final String variant : variants) {
            this.variants.register(variant);
        }
    }

    public void variants(final Action<NamedDomainObjectSet<Variant>> configureAction) {
        Configurable.configure(this.variants, configureAction);
    }

    Set<Map<String, Object>> prepareDataForGeneration() {
        final Map<String, Map<String, Object>> configData = this.loadConfig(this.getDataFiles(), !this.getVariants().isEmpty());
        if (this.getVariants().isEmpty()) {
            // non-variant mode
            final Map<String, Object> result = configData.get(null);
            if (result == null) {
                return Collections.singleton(this.getProperties().get());
            } else {
                result.putAll(this.getProperties().get());
                return Collections.singleton(result);
            }
        } else {
            // figure out any global data
            Map<String, Object> global = configData.remove(null);
            if (global == null) {
                global = this.getProperties().getOrElse(Collections.emptyMap());
            } else {
                global.putAll(this.getProperties().getOrElse(Collections.emptyMap()));
            }
            final Set<Map<String, Object>> output = new HashSet<>();
            // then get the per-variant bits
            for (final Variant variant : this.getVariants()) {
                // global, from file
                final Map<String, Object> variantData = new LinkedHashMap<>(global);

                // variant, from global files
                final Map<String, Object> variantFromGlobalFile = configData.remove(variant.getName());
                if (variantFromGlobalFile != null) {
                    variantData.putAll(variantFromGlobalFile);
                }

                // variant, from variant files
                final Map<String, Object> variantFromFile = this.loadConfig(variant.getDataFiles(), false).get(null);
                if (variantFromFile != null) {
                    variantData.putAll(variantFromFile);
                }

                // variant, in-memory
                variantData.putAll(variant.getProperties().getOrElse(Collections.emptyMap()));

                output.add(variantData);
            }

            if (!configData.isEmpty()) {
                throw new InvalidUserDataException("Unknown variants declared in file for template set " + this.getName() + ": " + configData.keySet());
            }

            return output;
        }
    }

    private Map<String, Map<String, Object>> loadConfig(final ConfigurableFileCollection files, final boolean useVariants) {
        final LoadSettings settings = LoadSettings.builder()
            .setLabel("Template set " + this.getName())
            .build();
        final Load load = new Load(settings);

        final Map<String, Map<String, Object>> templateParams = new HashMap<>();
        for (final File file : files.getAsFileTree()) {
            if (!file.isFile()) {
                continue;
            }
            try (final BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
                final Object data = load.loadFromReader(reader);
                this.unmarshalData(templateParams, data, useVariants);
            } catch (final YamlEngineException ex) {
                throw new InvalidUserDataException("Invalid input in " + file, ex);
            } catch (final IOException ex) {
                throw new GradleException("Failed to load data from " + file, ex);
            }
        }
        return templateParams;
    }

    private void unmarshalData(final Map<String, Map<String, Object>> output, final Object data, final boolean useVariants) {
        if (!(data instanceof Map<?, ?>)) {
            throw new InvalidUserDataException("Template data files must have a mapping as the root node");
        }

        final Map<?, ?> dataMap = (Map<?, ?>) data;
        if (useVariants) {
            final Object variants = dataMap.remove("variants");
            if (variants != null) {
                if (!(variants instanceof Map<?, ?>)) {
                    throw new InvalidUserDataException("value of 'variants' entry must be a mapping of String to Map<String, Object>");
                }

                for (final Map.Entry<?, ?> variant : ((Map<?, ?>) variants).entrySet()) {
                    if (!(variant.getValue() instanceof Map<?, ?>)) {
                        throw new InvalidUserDataException("Variant '" + variant.getKey() + "' was expected to have a mapping value, but it was a " + variant.getValue().getClass());
                    }
                    output.put(String.valueOf(variant.getKey()), TemplateSet.makeStringKeys((Map<?, ?>) variant.getValue()));
                }
            }
        }

        output.put(null, TemplateSet.makeStringKeys((Map<?, ?>) data));
    }

    private static Map<String, Object> makeStringKeys(final Map<?, ?> map) {
        final Map<String, Object> ret = new LinkedHashMap<>();
        for (final Map.Entry<?, ?> entry : map.entrySet()) {
            ret.put(entry.getKey() == null ? null : entry.getKey().toString(), entry.getValue());
        }
        return ret;
    }

}
