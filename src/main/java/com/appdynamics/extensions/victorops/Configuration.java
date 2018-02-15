/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extensions.victorops;


public class Configuration {

    private String voOrganizationKey;
    private String voRoutingKey;
    private String protocol;
    private String voAlertHost;
    private String connectTimeout = "10000";
    private String socketTimeout = "10000";
    private String voAlertUrlPath;
    private String showDetails = "false";
    private String controllerUrl;

    public String getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String showDetails) {
        this.showDetails = showDetails;
    }

    public String getVoOrganizationKey() {
        return voOrganizationKey;
    }

    public void setVoOrganizationKey(String voOrganizationKey) {
        this.voOrganizationKey = voOrganizationKey;
    }

    public String getVoRoutingKey() {
        return voRoutingKey;
    }

    public void setVoRoutingKey(String voRoutingKey) {
        this.voRoutingKey = voRoutingKey;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVoAlertHost() {
        return voAlertHost;
    }

    public void setVoAlertHost(String voAlertHost) {
        this.voAlertHost = voAlertHost;
    }

    public String getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getSocketTimeout() {
        return socketTimeout;
    }

    public void setSocketTimeout(String socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public String getVoAlertUrlPath() {
        return voAlertUrlPath;
    }

    public void setVoAlertUrlPath(String voAlertUrlPath) {
        this.voAlertUrlPath = voAlertUrlPath;
    }

    public String getControllerUrl() {
        return controllerUrl;
    }

    public void setControllerUrl(String controllerUrl) {
        this.controllerUrl = controllerUrl;
    }
}
