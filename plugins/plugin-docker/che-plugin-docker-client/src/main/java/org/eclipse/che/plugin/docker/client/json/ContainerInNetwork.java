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
package org.eclipse.che.plugin.docker.client.json;

/**
 * author Alexander Garagatyi
 */
public class ContainerInNetwork {
    private String endpointID;
    private String macAddress;
    private String iPv4Address;
    private String iPv6Address;

    public String getEndpointID() {
        return endpointID;
    }

    public void setEndpointID(String endpointID) {
        this.endpointID = endpointID;
    }

    public ContainerInNetwork withEndpointID(String endpointID) {
        this.endpointID = endpointID;
        return this;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public ContainerInNetwork withMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    public String getIPv4Address() {
        return iPv4Address;
    }

    public void setIPv4Address(String iPv4Address) {
        this.iPv4Address = iPv4Address;
    }

    public ContainerInNetwork withIPv4Address(String iPv4Address) {
        this.iPv4Address = iPv4Address;
        return this;
    }

    public String getIPv6Address() {
        return iPv6Address;
    }

    public void setiPv6Address(String iPv6Address) {
        this.iPv6Address = iPv6Address;
    }

    public ContainerInNetwork withIPv6Address(String iPv6Address) {
        this.iPv6Address = iPv6Address;
        return this;
    }

    @Override
    public String toString() {
        return "ContainerInNetwork{" +
               "endpointID='" + endpointID + '\'' +
               ", macAddress='" + macAddress + '\'' +
               ", iPv4Address='" + iPv4Address + '\'' +
               ", iPv6Address='" + iPv6Address + '\'' +
               '}';
    }
}