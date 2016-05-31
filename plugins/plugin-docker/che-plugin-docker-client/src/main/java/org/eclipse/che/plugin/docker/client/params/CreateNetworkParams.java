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
package org.eclipse.che.plugin.docker.client.params;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Arguments holder for {@link org.eclipse.che.plugin.docker.client.DockerConnector#createNetwork(CreateNetworkParams)}.
 *
 * author Alexander Garagatyi
 */
public class CreateNetworkParams {
    private String name;
    private String driver;
    // todo do we need IPAM conf? see https://docs.docker.com/engine/reference/api/docker_remote_api_v1.21/#create-a-network

    private CreateNetworkParams() {}

    /**
     * Creates arguments holder with required parameters.
     *
     * @param netName
     *         network name
     * @return arguments holder with required parameters
     * @throws NullPointerException
     *         if {@code netName} is null
     */
    public static CreateNetworkParams create(@NotNull String netName) {
        return new CreateNetworkParams().withName(netName);
    }

    /**
     * Adds network name to this parameters.
     *
     * @param netName
     *         network name
     * @return this params instance
     * @throws NullPointerException
     *         if {@code netName} is null
     */
    public CreateNetworkParams withName(@NotNull String netName) {
        this.name = netName;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateNetworkParams withDriver(String driver) {
        this.driver = driver;
        return this;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateNetworkParams)) return false;
        CreateNetworkParams that = (CreateNetworkParams)o;
        return Objects.equals(name, that.name) &&
               Objects.equals(driver, that.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driver);
    }

    @Override
    public String toString() {
        return "CreateNetworkParams{" +
               "name='" + name + '\'' +
               ", driver='" + driver + '\'' +
               '}';
    }
}
