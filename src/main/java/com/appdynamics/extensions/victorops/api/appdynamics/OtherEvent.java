package com.appdynamics.extensions.victorops.api.appdynamics;

import java.util.ArrayList;
import java.util.List;

public class OtherEvent extends Event{

    private String eventNotificationName;
    private String eventNotificationId;
    private String eventNotificationIntervalInMin;
    private String numberOfEventTypes;
    private String eventNotificationTime;
    private String numberOfEventSummaries;
    private List<EventType> eventTypes = new ArrayList<EventType>();
    private List<EventSummary> eventSummaries = new ArrayList<EventSummary>();

    public String getEventNotificationName() {
        return eventNotificationName;
    }

    public void setEventNotificationName(String eventNotificationName) {
        this.eventNotificationName = eventNotificationName;
    }

    public String getEventNotificationId() {
        return eventNotificationId;
    }

    public void setEventNotificationId(String eventNotificationId) {
        this.eventNotificationId = eventNotificationId;
    }

    public String getEventNotificationIntervalInMin() {
        return eventNotificationIntervalInMin;
    }

    public void setEventNotificationIntervalInMin(String eventNotificationIntervalInMin) {
        this.eventNotificationIntervalInMin = eventNotificationIntervalInMin;
    }

    public String getNumberOfEventTypes() {
        return numberOfEventTypes;
    }

    public void setNumberOfEventTypes(String numberOfEventTypes) {
        this.numberOfEventTypes = numberOfEventTypes;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public List<EventSummary> getEventSummaries() {
        return eventSummaries;
    }

    public void setEventSummaries(List<EventSummary> eventSummaries) {
        this.eventSummaries = eventSummaries;
    }

    public String getEventNotificationTime() {
        return eventNotificationTime;
    }

    public void setEventNotificationTime(String eventNotificationTime) {
        this.eventNotificationTime = eventNotificationTime;
    }

    public String getNumberOfEventSummaries() {
        return numberOfEventSummaries;
    }

    public void setNumberOfEventSummaries(String numberOfEventSummaries) {
        this.numberOfEventSummaries = numberOfEventSummaries;
    }
}
