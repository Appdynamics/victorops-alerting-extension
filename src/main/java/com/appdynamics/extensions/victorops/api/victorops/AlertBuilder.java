package com.appdynamics.extensions.victorops.api.victorops;

import com.appdynamics.extensions.victorops.Configuration;
import com.appdynamics.extensions.victorops.api.appdynamics.HealthRuleViolationEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

/**
 * Builds an Alert from Health Rule violation event.
 */

public class AlertBuilder {

    public static final String DASH_SEPARATOR = "-";
    public static final String SLASH_SEPARATOR = "/";
    public static final String APP_DYNAMICS = "AppDynamics";
    private static Logger logger = Logger.getLogger(AlertBuilder.class);

    public Alert buildAlert(HealthRuleViolationEvent violationEvent,Configuration config) {
        if(violationEvent != null && config != null){
            Alert alert = new Alert();
            alert.setOrgKey(config.getVoOrganizationKey());
            alert.setRoutingKey(config.getVoRoutingKey());
            alert.setMessageType(getMessageType(violationEvent));
            alert.setEntityId(getEntityId(violationEvent));
            alert.setStateMessage(violationEvent.getSummaryMessage());
            alert.setEntityDisplayName(getEntityDisplayName(violationEvent));
            alert.setAdEventType(violationEvent.getEventType());
            alert.setAlertUrl(getAlertUrl(violationEvent));
            alert.setApDetails(getSummary(violationEvent));
            alert.setMonitoringTool(APP_DYNAMICS);
            return alert;
        }
        return null;
    }


    public String convertIntoJsonString(Alert alert) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(alert);
    }

    private String getAlertUrl(HealthRuleViolationEvent violationEvent) {
        return violationEvent.getDeepLinkUrl()+violationEvent.getIncidentID();
    }

    private Alert.MessageTypeEnum getMessageType(HealthRuleViolationEvent violationEvent) {
        if(violationEvent.getEventType() != null){
            if(violationEvent.getEventType().equalsIgnoreCase("POLICY_CLOSE")){
                return Alert.MessageTypeEnum.RECOVERY;
            }
            else if(violationEvent.getSeverity().equalsIgnoreCase("WARN")){
                return Alert.MessageTypeEnum.WARNING;
            }
            else if(violationEvent.getSeverity().equalsIgnoreCase("ERROR")){
                return Alert.MessageTypeEnum.CRITICAL;
            }
        }
        return Alert.MessageTypeEnum.INFO;
    }

    private AlertDetails getSummary(HealthRuleViolationEvent violationEvent) {
        AlertDetails details = new AlertDetails();
        details.setApplicationName(violationEvent.getAppName());
        details.setPolicyViolationAlertTime(violationEvent.getPvnAlertTime());
        details.setSeverity(violationEvent.getSeverity());
        details.setPriority(violationEvent.getPriority());
        details.setHealthRuleName(violationEvent.getHealthRuleName());
        details.setAffectedEntityType(violationEvent.getAffectedEntityType());
        details.setAffectedEntityName(violationEvent.getAffectedEntityName());
        details.setIncidentId(violationEvent.getIncidentID());
        return details;
    }


    private String getEntityDisplayName(HealthRuleViolationEvent violationEvent) {
        return violationEvent.getAppName() + SLASH_SEPARATOR + violationEvent.getAffectedEntityName() + SLASH_SEPARATOR + violationEvent.getHealthRuleName();
    }

    private String getEntityId(HealthRuleViolationEvent violationEvent) {
        return violationEvent.getAppID() + DASH_SEPARATOR + violationEvent.getAffectedEntityID() + DASH_SEPARATOR + violationEvent.getHealthRuleID();
    }

}
