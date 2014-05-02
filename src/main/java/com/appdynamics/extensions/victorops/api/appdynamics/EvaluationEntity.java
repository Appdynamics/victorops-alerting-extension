package com.appdynamics.extensions.victorops.api.appdynamics;


import java.util.ArrayList;
import java.util.List;

public class EvaluationEntity {

    private String type;
    private String name;
    private String id;
    private String numberOfTriggeredConditions;
    private List<TriggerCondition> triggeredConditions = new ArrayList<TriggerCondition>();

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

    public List<TriggerCondition> getTriggeredConditions() {
        return triggeredConditions;
    }

    public void setTriggeredConditions(List<TriggerCondition> triggeredConditions) {
        this.triggeredConditions = triggeredConditions;
    }
}
