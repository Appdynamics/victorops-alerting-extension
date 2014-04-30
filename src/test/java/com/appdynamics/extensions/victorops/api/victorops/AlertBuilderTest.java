package com.appdynamics.extensions.victorops.api.victorops;


import com.appdynamics.extensions.victorops.Configuration;
import com.appdynamics.extensions.victorops.api.appdynamics.HealthRuleViolationEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;

public class AlertBuilderTest {

    AlertBuilder alertBuilderTest = new AlertBuilder();

    @Test
    public void canSerializeHealthRuleViolationIntoAlertJson() throws JsonProcessingException {
        HealthRuleViolationEvent hrv = createHealthRuleViolationEvent();
        Configuration config = createConfig();
        Alert alert = alertBuilderTest.buildAlert(hrv,config);
        String alertJson = alertBuilderTest.convertIntoJsonString(alert);
        Assert.assertTrue(alertJson != null);
    }

    private Configuration createConfig() {
        Configuration config = new Configuration();
        config.setProtocol("https");
        config.setVoAlertHost("alertHost");
        config.setVoOrganizationKey("orgKey");
        config.setVoRoutingKey("routeKey");
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
        hrv.setDeepLinkUrl("url");
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