/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extensions.victorops.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Alert {

    public enum MessageTypeEnum {
        RECOVERY,
        WARNING,
        CRITICAL,
        INFO
    }

    @JsonProperty("message_type")
    private MessageTypeEnum messageType;

    @JsonProperty("entity_id")
    private String entityId;

    @JsonProperty("VO_ORGANIZATION_KEY")
    private String orgKey;

    @JsonProperty("VO_ROUTING_KEY")
    private String routingKey;

    @JsonProperty("state_message")
    private String stateMessage;

    @JsonProperty("entity_display_name")
    private String entityDisplayName;

    @JsonProperty("ad_event_type")
    private String adEventType;

    @JsonProperty("alert_url")
    private String alertUrl;

    @JsonProperty("ap_details")
    private AlertDetails apDetails;

    @JsonProperty("monitoring_tool")
    private String monitoringTool;


    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    public String getMonitoringTool() {
        return monitoringTool;
    }

    public void setMonitoringTool(String monitoringTool) {
        this.monitoringTool = monitoringTool;
    }

    public String getAlertUrl() {
        return alertUrl;
    }

    public void setAlertUrl(String alertUrl) {
        this.alertUrl = alertUrl;
    }

    public AlertDetails getApDetails() {
        return apDetails;
    }

    public void setApDetails(AlertDetails apDetails) {
        this.apDetails = apDetails;
    }

    public String getAdEventType() {
        return adEventType;
    }

    public void setAdEventType(String adEventType) {
        this.adEventType = adEventType;
    }

    public String getEntityDisplayName() {
        return entityDisplayName;
    }

    public void setEntityDisplayName(String entityDisplayName) {
        this.entityDisplayName = entityDisplayName;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getOrgKey() {
        return orgKey;
    }

    public void setOrgKey(String orgKey) {
        this.orgKey = orgKey;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
