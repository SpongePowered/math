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
