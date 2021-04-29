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
import org.gradle.api.Named;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Nested;

import javax.inject.Inject;

/**
 * Template variant.
 *
 * <p>Composed of:</p>
 * <ul>
 *     <li>Name: not used for anything</li>
 *     <li>Source files: files that will be loaded</li>
 *     <li>Runtime properties: set in the buildscript, will override anything
 *     set in source files</li>
 * </ul>
 */
public class Variant implements Named {

    private final String name;
    private final ConfigurableFileCollection sourceFiles;
    private final MapProperty<String, Object> runtimeProperties;

    @Inject
    public Variant(final String name, final ObjectFactory objects) {
        this.name = name;
        this.sourceFiles = objects.fileCollection();
        this.runtimeProperties = objects.mapProperty(String.class, Object.class);
    }

    @Override
    @Input
    public String getName() {
        return this.name;
    }

    // data files, will be interpreted literally
    @InputFiles
    public ConfigurableFileCollection getDataFiles() {
        return this.sourceFiles;
    }

    @Nested
    public MapProperty<String, Object> getProperties() {
        return this.runtimeProperties;
    }

    public void properties(final Action<MapProperty<String, Object>> configureAction) {
        Configurable.configure(this.runtimeProperties, configureAction);
    }

}
