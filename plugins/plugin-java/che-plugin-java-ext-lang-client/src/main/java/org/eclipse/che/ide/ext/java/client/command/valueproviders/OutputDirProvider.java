/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.java.client.command.valueproviders;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.api.promises.client.PromiseProvider;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Project;
import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.ext.java.client.util.JavaUtil;
import org.eclipse.che.ide.extension.machine.client.command.valueproviders.CommandPropertyValueProvider;

import static org.eclipse.che.ide.ext.java.shared.Constants.OUTPUT_FOLDER;

/**
 * Provides a path to the project's output directory.
 *
 * @author Valeriy Svydenko
 */
@Singleton
public class OutputDirProvider implements CommandPropertyValueProvider {
    private static final String KEY = "${project.java.output.dir}";

    private final AppContext      appContext;
    private final PromiseProvider promises;

    @Inject
    public OutputDirProvider(AppContext appContext, PromiseProvider promises) {
        this.appContext = appContext;
        this.promises = promises;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public Promise<String> getValue() {
        final Resource[] resources = appContext.getResources();

        if (resources != null && resources.length == 1) {

            final Resource resource = resources[0];
            final Project project = resource.getRelatedProject();

            if (JavaUtil.isJavaProject(project) && project.getAttributes().containsKey(OUTPUT_FOLDER)) {
                return promises.resolve(appContext.getProjectsRoot() + project.getAttributes().get(OUTPUT_FOLDER).get(0));
            } else {
                return promises.resolve(appContext.getProjectsRoot() + project.getLocation());
            }
        }

        return promises.resolve("");
    }

}