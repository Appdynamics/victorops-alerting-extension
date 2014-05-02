package com.appdynamics.extensions.victorops.api.appdynamics;


public class EventSummary {

    private String eventSummaryId;
    private String eventSummaryTime;
    private String eventSummaryType;
    private String eventSummarySeverity;
    private String eventSummaryString;

    public String getEventSummaryId() {
        return eventSummaryId;
    }

    public void setEventSummaryId(String eventSummaryId) {
        this.eventSummaryId = eventSummaryId;
    }

    public String getEventSummaryTime() {
        return eventSummaryTime;
    }

    public void setEventSummaryTime(String eventSummaryTime) {
        this.eventSummaryTime = eventSummaryTime;
    }

    public String getEventSummaryType() {
        return eventSummaryType;
    }

    public void setEventSummaryType(String eventSummaryType) {
        this.eventSummaryType = eventSummaryType;
    }

    public String getEventSummarySeverity() {
        return eventSummarySeverity;
    }

    public void setEventSummarySeverity(String eventSummarySeverity) {
        this.eventSummarySeverity = eventSummarySeverity;
    }

    public String getEventSummaryString() {
        return eventSummaryString;
    }

    public void setEventSummaryString(String eventSummaryString) {
        this.eventSummaryString = eventSummaryString;
    }
}
