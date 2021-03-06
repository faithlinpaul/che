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
package org.eclipse.che.plugin.debugger.ide.configuration;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import org.eclipse.che.ide.api.action.AbstractPerspectiveAction;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.debug.DebugConfiguration;
import org.eclipse.che.ide.api.debug.DebugConfigurationsManager;
import org.eclipse.che.plugin.debugger.ide.DebuggerLocalizationConstant;

import java.util.Collections;

import static org.eclipse.che.ide.workspace.perspectives.project.ProjectPerspective.PROJECT_PERSPECTIVE_ID;

/**
 * Action for selecting (changing) current debug configuration.
 *
 * @author Artem Zatsarynnyi
 */
public class DebugConfigurationAction extends AbstractPerspectiveAction {

    private static final String TICK = "> ";

    private final DebugConfigurationsManager configurationsManager;
    private final DebugConfiguration         configuration;

    @Inject
    public DebugConfigurationAction(DebugConfigurationsManager debugConfigurationsManager,
                                    @Assisted DebugConfiguration configuration,
                                    DebuggerLocalizationConstant localizationConstants) {
        super(Collections.singletonList(PROJECT_PERSPECTIVE_ID),
              configuration.getName(),
              localizationConstants.debugConfigurationActionDescription(),
              null,
              null);
        configurationsManager = debugConfigurationsManager;
        this.configuration = configuration;
    }

    @Override
    public void updateInPerspective(ActionEvent event) {
        Optional<DebugConfiguration> configurationOptional = configurationsManager.getCurrentDebugConfiguration();
        if (configurationOptional.isPresent() && configuration.equals(configurationOptional.get())) {
            event.getPresentation().setText(TICK + configuration.getName());
        } else {
            event.getPresentation().setText(configuration.getName());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        configurationsManager.setCurrentDebugConfiguration(configuration);
    }
}
