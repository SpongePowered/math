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

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.DelegatingLoader;
import com.mitchellbosecke.pebble.loader.FileLoader;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import net.kyori.mammoth.Properties;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.gradle.api.DefaultTask;
import org.gradle.api.InvalidUserDataException;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.Optional;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public abstract class GenerateTemplates extends DefaultTask {

    private static final String FILE_NAME_CACHE_DISAMBIGUATOR = "###";
    private static final String PEBBLE_EXTENSION = ".peb";

    /**
     * The set the template is generated from.
     *
     * @return the template set
     */
    @Nested
    public abstract Property<TemplateSet> getBaseSet();

    @InputDirectory
    @Optional
    public abstract DirectoryProperty getIncludesDirectory(); // for files that can be included but are not themselves evaluated

    @InputDirectory
    public abstract DirectoryProperty getSourceDirectory();

    @OutputDirectory
    public abstract DirectoryProperty getOutputDir();

    @TaskAction
    void generate() throws IOException {
        final Path sourceDirectory = this.getSourceDirectory().get().getAsFile().toPath();
        final Loader<?> sourceLoader = new FileLoader();
        sourceLoader.setPrefix(sourceDirectory.toAbsolutePath().toString());
        final Loader<?> loader;

        if (this.getIncludesDirectory().isPresent()) {
            final Loader<?> includesLoader = new FileLoader();
            includesLoader.setPrefix(this.getIncludesDirectory().get().getAsFile().getAbsolutePath());
            loader = new DelegatingLoader(Arrays.asList(sourceLoader, includesLoader));
        } else {
            loader = sourceLoader;
        }


        // By default, resolves FS paths
        // todo: restrict inputs to inputs and includes
        final PebbleEngine engine = new PebbleEngine.Builder()
            .autoEscaping(false) // no html escaping
            .defaultLocale(Locale.ROOT)
            .loader(loader)
            // .cacheActive(false) // xX: overlap between file names and template names causes issues
            .strictVariables(true) // make sure to fail when vars are not present
            .build();


        final Path outputDirectory = this.getOutputDir().get().getAsFile().toPath();
        Files.createDirectories(outputDirectory);
        final Set<Map<String, Object>> variants = this.getBaseSet().get().prepareDataForGeneration();
        final @Nullable String header = Properties.finalized(this.getBaseSet().get().getHeader()).getOrNull();

        final Set<String> seenOutputs = new HashSet<>();
        Files.walkFileTree(sourceDirectory, new FileVisitor<Path>() {
            // @formatter:off
            @Override public FileVisitResult preVisitDirectory(final Path dir, final BasicFileAttributes attrs) { return FileVisitResult.CONTINUE; }
            @Override public FileVisitResult visitFileFailed(final Path file, final IOException exc) { return FileVisitResult.CONTINUE; }
            @Override public FileVisitResult postVisitDirectory(final Path dir, final IOException exc) { return FileVisitResult.CONTINUE; }
            // @formatter:on

            @Override
            public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
                // Parse the template
                final String relativePath = sourceDirectory.relativize(file).toString();
                final PebbleTemplate fileNameTemplate = engine.getLiteralTemplate(GenerateTemplates.FILE_NAME_CACHE_DISAMBIGUATOR + relativePath);
                final PebbleTemplate template = engine.getTemplate(relativePath);

                // Then generate outputs for every variant
                for (final Map<String, Object> variant : variants) {
                    String outputFile = GenerateTemplates.this.evaluateToString(fileNameTemplate, variant)
                        .substring(GenerateTemplates.FILE_NAME_CACHE_DISAMBIGUATOR.length());
                    if (outputFile.endsWith(GenerateTemplates.PEBBLE_EXTENSION)) {
                        outputFile = outputFile.substring(0, outputFile.length() - GenerateTemplates.PEBBLE_EXTENSION.length());
                    }

                    if (!seenOutputs.add(outputFile)) {
                        throw new InvalidUserDataException("Output file " + outputFile + " (a variant of input " + relativePath + ") has already been "
                            + "written in another variant!");
                    }

                    final Path output = outputDirectory.resolve(outputFile);
                    Files.createDirectories(output.getParent());
                    try (final BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
                        if (header != null) {
                            writer.write(header);
                            writer.write(System.lineSeparator());
                        }
                        template.evaluate(writer, variant);
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private String evaluateToString(final PebbleTemplate template, final Map<String, Object> data) throws IOException {
        final StringWriter writer = new StringWriter();
        template.evaluate(writer, data);
        return writer.toString();
    }

}
