package com.appdynamics.extensions.victorops.api.appdynamics;


import java.util.ArrayList;
import java.util.List;

public class HealthRuleViolationEvent extends Event{
    private String pvnAlertTime;
    private String healthRuleName;
    private String healthRuleID;
    private String pvnTimePeriodInMinutes;
    private String affectedEntityType;
    private String affectedEntityName;
    private String affectedEntityID;
    private List<EvaluationEntity> evaluationEntity = new ArrayList<EvaluationEntity>();
    private String summaryMessage;
    private String incidentID;
    private String eventType;

    public String getPvnAlertTime() {
        return pvnAlertTime;
    }

    public void setPvnAlertTime(String pvnAlertTime) {
        this.pvnAlertTime = pvnAlertTime;
    }

    public String getHealthRuleName() {
        return healthRuleName;
    }

    public void setHealthRuleName(String healthRuleName) {
        this.healthRuleName = healthRuleName;
    }

    public String getHealthRuleID() {
        return healthRuleID;
    }

    public void setHealthRuleID(String healthRuleID) {
        this.healthRuleID = healthRuleID;
    }

    public String getPvnTimePeriodInMinutes() {
        return pvnTimePeriodInMinutes;
    }

    public void setPvnTimePeriodInMinutes(String pvnTimePeriodInMinutes) {
        this.pvnTimePeriodInMinutes = pvnTimePeriodInMinutes;
    }

    public String getAffectedEntityType() {
        return affectedEntityType;
    }

    public void setAffectedEntityType(String affectedEntityType) {
        this.affectedEntityType = affectedEntityType;
    }

    public String getAffectedEntityName() {
        return affectedEntityName;
    }

    public void setAffectedEntityName(String affectedEntityName) {
        this.affectedEntityName = affectedEntityName;
    }

    public String getAffectedEntityID() {
        return affectedEntityID;
    }

    public void setAffectedEntityID(String affectedEntityID) {
        this.affectedEntityID = affectedEntityID;
    }

    public String getSummaryMessage() {
        return summaryMessage;
    }

    public void setSummaryMessage(String summaryMessage) {
        this.summaryMessage = summaryMessage;
    }

    public String getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(String incidentID) {
        this.incidentID = incidentID;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public List<EvaluationEntity> getEvaluationEntity() {
        return evaluationEntity;
    }

    public void setEvaluationEntity(List<EvaluationEntity> evaluationEntity) {
        this.evaluationEntity = evaluationEntity;
    }
}
