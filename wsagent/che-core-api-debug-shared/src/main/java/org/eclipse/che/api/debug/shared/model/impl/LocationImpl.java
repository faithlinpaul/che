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
package org.eclipse.che.api.debug.shared.model.impl;

import org.eclipse.che.api.debug.shared.model.Location;

import java.util.Objects;

/**
 * @author Anatoliy Bazko
 */
public class LocationImpl implements Location {
    private final String  target;
    private final int     lineNumber;
    private final boolean externalResource;
    private final int     externalResourceId;
    private final String  projectPath;

    public LocationImpl(String target, int lineNumber, boolean externalResource, int externalResourceId, String projectPath) {
        this.target = target;
        this.lineNumber = lineNumber;
        this.externalResource = externalResource;
        this.externalResourceId = externalResourceId;
        this.projectPath = projectPath;
    }

    public LocationImpl(String target, int lineNumber) {
        this(target, lineNumber, false, 0, null);
    }

    public LocationImpl(String target) {
        this(target, 0, false, 0, null);
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public boolean isExternalResource() {
        return externalResource;
    }

    @Override
    public int getExternalResourceId() {
        return externalResourceId;
    }

    @Override
    public String getProjectPath() {
        return projectPath;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationImpl)) return false;

        LocationImpl location = (LocationImpl)o;

        return (lineNumber != location.lineNumber ||
                externalResource != location.externalResource ||
                externalResourceId != location.externalResourceId ||
                Objects.equals(projectPath, location.projectPath) &&
                !(target != null ? !target.equals(location.target) : location.target != null));

    }

    @Override
    public int hashCode() {
        int result = target != null ? target.hashCode() : 0;
        result = 31 * result + lineNumber;
        result = 31 * result + externalResourceId;
        result = 31 * result + Objects.hashCode(externalResource);
        result = 31 * result + Objects.hashCode(projectPath);
        return result;
    }
}
