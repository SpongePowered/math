package org.spongepowered.gradle.math.templates;

import net.kyori.mammoth.Configurable;
import org.gradle.api.Action;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

public class SourceSetTemplateExtensionImpl implements SourceSetTemplateExtension {

    private static final String SINGLE_SET_NAME = "main";

    private final NamedDomainObjectContainer<TemplateSet> templateSets;
    private boolean singleSetMode;

    @Inject
    public SourceSetTemplateExtensionImpl(final ObjectFactory objects) {
        this.templateSets = objects.domainObjectContainer(TemplateSet.class);
    }

    boolean singleSetMode() {
        return this.singleSetMode;
    }

    @Override
    public void singleSet(final Action<TemplateSet> properties) {
        this.singleSetMode = true;
        Configurable.configure(this.templateSets.maybeCreate(SourceSetTemplateExtensionImpl.SINGLE_SET_NAME), properties);
    }

    @Override
    public NamedDomainObjectContainer<TemplateSet> getTemplateSets() {
        return this.templateSets;
    }
}
