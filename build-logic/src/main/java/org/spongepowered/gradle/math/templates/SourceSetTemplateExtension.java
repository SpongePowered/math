package org.spongepowered.gradle.math.templates;

import net.kyori.mammoth.Configurable;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.tasks.Nested;

/**
 * Templates per-SourceSet
 */
public interface SourceSetTemplateExtension {

    // single batch, at src/<name>/templates
    void singleSet(final Action<TemplateSet> properties);

    // batches, at src/<set>/templates/<batch>
    NamedDomainObjectContainer<TemplateSet> getTemplateSets(); // todo: maybe make this polymorphic, have the variant-aware template set be a different design?

    default void templateSets(final Action<NamedDomainObjectContainer<TemplateSet>> configurer) {
        Configurable.configure(this.getTemplateSets(), configurer);
    }
}
