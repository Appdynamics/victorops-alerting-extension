package com.appdynamics.extensions.victorops.api.victorops;


import com.appdynamics.extensions.victorops.api.appdynamics.EvaluationEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AlertDetails {

    @JsonProperty("Application Name")
    private String applicationName;

    @JsonProperty("Policy Violation Alert Time")
    private String policyViolationAlertTime;

    @JsonProperty("Severity")
    private String severity;

    @JsonProperty("Priority")
    private String priority;

    @JsonProperty("Name of Violated Health Rule")
    private String healthRuleName;

    @JsonProperty("Affected Entity Type")
    private String affectedEntityType;

    @JsonProperty("Name of Affected Entity")
    private String affectedEntityName;

    @JsonProperty("Incident ID")
    private String incidentId;

    @JsonProperty("Evaluation Entities")
    private List<AlertEvaluationEntity> evaluationEntities = new ArrayList<AlertEvaluationEntity>();

    public List<AlertEvaluationEntity> getEvaluationEntities() {
        return evaluationEntities;
    }

    public void setEvaluationEntities(List<AlertEvaluationEntity> evaluationEntities) {
        this.evaluationEntities = evaluationEntities;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getPolicyViolationAlertTime() {
        return policyViolationAlertTime;
    }

    public void setPolicyViolationAlertTime(String policyViolationAlertTime) {
        this.policyViolationAlertTime = policyViolationAlertTime;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getHealthRuleName() {
        return healthRuleName;
    }

    public void setHealthRuleName(String healthRuleName) {
        this.healthRuleName = healthRuleName;
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

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }


}
