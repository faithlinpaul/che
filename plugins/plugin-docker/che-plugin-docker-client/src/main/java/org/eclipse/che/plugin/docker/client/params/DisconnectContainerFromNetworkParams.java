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

import static java.util.Objects.requireNonNull;

/**
 * Arguments holder for {@link org.eclipse.che.plugin.docker.client.DockerConnector#disconnectContainerFromNetwork(DisconnectContainerFromNetworkParams)}.
 *
 * author Alexander Garagatyi
 */
public class DisconnectContainerFromNetworkParams {
    private String netId;
    private String container;

    private DisconnectContainerFromNetworkParams() {}

    /**
     * Creates arguments holder with required parameters.
     *
     * @param netId
     *         network identifier
     * @param containerId
     *         container identifier
     * @return arguments holder with required parameters
     * @throws NullPointerException
     *         if {@code netId} or {@code container} is null
     */
    public static DisconnectContainerFromNetworkParams create(@NotNull String netId, @NotNull String containerId) {
        return new DisconnectContainerFromNetworkParams().withNetworkId(netId)
                                                         .withContainer(containerId);
    }

    /**
     * Adds network identifier to this parameters.
     *
     * @param netId
     *         network identifier
     * @return this params instance
     * @throws NullPointerException
     *         if {@code netId} is null
     */
    public DisconnectContainerFromNetworkParams withNetworkId(@NotNull String netId) {
        requireNonNull(netId);
        this.netId = netId;
        return this;
    }

    public String getNetworkId() {
        return netId;
    }

    /**
     * Adds container identifier to this parameters.
     *
     * @param containerId
     *         container identifier
     * @return this params instance
     * @throws NullPointerException
     *         if {@code container} is null
     */
    public DisconnectContainerFromNetworkParams withContainer(@NotNull String containerId) {
        requireNonNull(containerId);
        this.container = containerId;
        return this;
    }

    public String getContainer() {
        return container;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisconnectContainerFromNetworkParams)) return false;
        DisconnectContainerFromNetworkParams that = (DisconnectContainerFromNetworkParams)o;
        return Objects.equals(netId, that.netId) &&
               Objects.equals(container, that.container);
    }

    @Override
    public int hashCode() {
        return Objects.hash(netId, container);
    }

    @Override
    public String toString() {
        return "DisconnectContainerFromNetworkParams{" +
               "netId='" + netId + '\'' +
               ", container='" + container + '\'' +
               '}';
    }
}
