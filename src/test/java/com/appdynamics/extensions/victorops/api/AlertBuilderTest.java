/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extensions.victorops.api;


import com.appdynamics.extensions.alerts.customevents.HealthRuleViolationEvent;
import com.appdynamics.extensions.victorops.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class AlertBuilderTest {

    AlertBuilder alertBuilderTest = new AlertBuilder();

    @Test
    public void canSerializeHealthRuleViolationIntoAlertJson() throws JsonProcessingException {
        HealthRuleViolationEvent hrv = createHealthRuleViolationEvent();
        Configuration config = createConfig();
        Alert alert = alertBuilderTest.buildAlertFromHealthRuleViolationEvent(hrv, config);
        Assert.assertTrue(alert.getAlertUrl().startsWith("http://controller.host:8090"));
        String alertJson = alertBuilderTest.convertIntoJsonString(alert);
        Assert.assertTrue(alertJson != null);

    }

    private Configuration createConfig() {
        Configuration config = new Configuration();
        config.setProtocol("https");
        config.setVoAlertHost("alertHost");
        config.setVoOrganizationKey("orgKey");
        config.setVoRoutingKey("routeKey");
        config.setControllerUrl("http://controller.host:8090");
        return config;
    }

    private HealthRuleViolationEvent createHealthRuleViolationEvent() {
        HealthRuleViolationEvent hrv = new HealthRuleViolationEvent();
        hrv.setAffectedEntityName("affectedEntityName");
        hrv.setEventType("eventType");
        hrv.setAppName("appName");
        hrv.setAffectedEntityType("affectedEntityType");
        hrv.setIncidentID("incidentId");
        hrv.setSummaryMessage("summaryMessage");
        hrv.setDeepLinkUrl("http://windows:8080/mylocation#/test");
        hrv.setHealthRuleID("ruleId");
        hrv.setHealthRuleName("ruleName");
        hrv.setPvnAlertTime("pvnAlertTime");
        hrv.setPvnTimePeriodInMinutes("period");
        hrv.setAppID("124");
        hrv.setAppName("Appname");
        hrv.setPriority("HIGH");
        hrv.setSeverity("ALERRT");
        hrv.setTag("Appd");
        hrv.setAffectedEntityID("AffEntityID");
        return hrv;
    }


}
