package com.appdynamics.extensions.victorops.api.appdynamics;


public class TriggerCondition {

    private String scopeType;
    private String scopeName;
    private String scopeId;
    private String conditionName;
    private String conditionId;
    private String operator;
    private String conditionUnitType;
    private boolean useDefaultBaseline;
    private String baselineName;
    private String baselineId;
    private String thresholdValue;
    private String observedValue;

    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }

    public String getScopeId() {
        return scopeId;
    }

    public void setScopeId(String scopeId) {
        this.scopeId = scopeId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getConditionUnitType() {
        return conditionUnitType;
    }

    public void setConditionUnitType(String conditionUnitType) {
        this.conditionUnitType = conditionUnitType;
    }

    public boolean isUseDefaultBaseline() {
        return useDefaultBaseline;
    }

    public void setUseDefaultBaseline(boolean useDefaultBaseline) {
        this.useDefaultBaseline = useDefaultBaseline;
    }

    public String getBaselineName() {
        return baselineName;
    }

    public void setBaselineName(String baselineName) {
        this.baselineName = baselineName;
    }

    public String getBaselineId() {
        return baselineId;
    }

    public void setBaselineId(String baselineId) {
        this.baselineId = baselineId;
    }

    public String getThresholdValue() {
        return thresholdValue;
    }

    public void setThresholdValue(String thresholdValue) {
        this.thresholdValue = thresholdValue;
    }

    public String getObservedValue() {
        return observedValue;
    }

    public void setObservedValue(String observedValue) {
        this.observedValue = observedValue;
    }
}
