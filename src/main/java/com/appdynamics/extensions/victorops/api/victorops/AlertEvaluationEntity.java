package com.appdynamics.extensions.victorops.api.victorops;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AlertEvaluationEntity {
    @JsonProperty("Entity type")
    String type;

    @JsonProperty("Entity name")
    String name;

    @JsonProperty("Entity id")
    String id;

    @JsonProperty("No of triggered conds")
    String numberOfTriggeredConditions;

    @JsonProperty("Triggerd Conds")
    List<AlertTriggeredCondition> triggeredConditions = new ArrayList<AlertTriggeredCondition>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfTriggeredConditions() {
        return numberOfTriggeredConditions;
    }

    public void setNumberOfTriggeredConditions(String numberOfTriggeredConditions) {
        this.numberOfTriggeredConditions = numberOfTriggeredConditions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<AlertTriggeredCondition> getTriggeredConditions() {
        return triggeredConditions;
    }

    public void setTriggeredConditions(List<AlertTriggeredCondition> triggeredConditions) {
        this.triggeredConditions = triggeredConditions;
    }
}