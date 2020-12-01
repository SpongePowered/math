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
