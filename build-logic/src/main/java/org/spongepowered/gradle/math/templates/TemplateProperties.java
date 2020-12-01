package org.spongepowered.gradle.math.templates;

import net.kyori.mammoth.Configurable;
import org.gradle.api.Action;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.MapProperty;

import javax.inject.Inject;

public class TemplateProperties {

    private final MapProperty<String, Object> properties;

    @Inject
    public TemplateProperties(final ObjectFactory objects) {
        this.properties = objects.mapProperty(String.class, Object.class);
    }

    @Inject
    public MapProperty<String, Object> getProperties() {
        return this.properties;
    }

    public void properties(final Action<MapProperty<String, Object>> action) {
        Configurable.configure(this.properties, action);
    }

}
