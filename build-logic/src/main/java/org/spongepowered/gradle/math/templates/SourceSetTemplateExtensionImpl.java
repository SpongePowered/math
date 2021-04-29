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
