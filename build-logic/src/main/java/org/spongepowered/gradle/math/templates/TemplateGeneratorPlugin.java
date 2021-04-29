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

import net.kyori.mammoth.ProjectPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.file.Directory;
import org.gradle.api.plugins.Convention;
import org.gradle.api.plugins.ExtensionContainer;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.plugins.PluginContainer;
import org.gradle.api.provider.Provider;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.TaskProvider;

/**
 * Simple template generator.
 *
 * <p>Uses pebble templates, properties are applied on a sourceset level</p>
 */
public class TemplateGeneratorPlugin implements ProjectPlugin {

    private static final String GENERATION_GROUP = "generation";

    @Override
    public void apply(
        final @NonNull Project project,
        final @NonNull PluginContainer plugins,
        final @NonNull ExtensionContainer extensions,
        final @NonNull Convention convention,
        final @NonNull TaskContainer tasks
    ) {
        plugins.withType(JavaBasePlugin.class, $ -> {
            final SourceSetContainer sourceSets = extensions.getByType(SourceSetContainer.class);
            sourceSets.all(set -> {
                final SourceSetTemplateExtension extension = set.getExtensions().create(SourceSetTemplateExtension.class, "templates", SourceSetTemplateExtensionImpl.class, project.getObjects());
                final Directory inputDir = project.getLayout().getProjectDirectory().dir("src/" + set.getName() + "/template");
                final Provider<Directory> outputDir = project.getLayout().getBuildDirectory().dir("generated/sources/" + set.getName() + "-templates");

                // generate a task for each template set
                extension.getTemplateSets().all(templateSet -> {
                    final Provider<Directory> templateSetOutput = outputDir.map(it -> it.dir(templateSet.getName()));
                    final TaskProvider<GenerateTemplates> generateTask = tasks.register(set.getTaskName("generate", templateSet.getName() + "Templates"), GenerateTemplates.class, task -> {
                        task.setGroup(TemplateGeneratorPlugin.GENERATION_GROUP);
                        task.getBaseSet().set(templateSet);
                        task.getSourceDirectory().set(inputDir.dir(templateSet.getName())); // todo: handle singleSet mode?
                        task.getOutputDir().set(templateSetOutput);
                    });

                    // And add the output as a source directory
                    set.getJava().srcDir(generateTask.map(DefaultTask::getOutputs));
                });
            });
        });
    }
}
