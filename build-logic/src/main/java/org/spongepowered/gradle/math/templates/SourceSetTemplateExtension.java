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
