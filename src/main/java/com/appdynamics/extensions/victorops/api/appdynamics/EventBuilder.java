package com.appdynamics.extensions.victorops.api.appdynamics;


import com.appdynamics.extensions.victorops.Configuration;
import com.appdynamics.extensions.victorops.common.StringHelper;
import org.apache.log4j.Logger;

/**
 * Builds an event from command line arguments.
 */

public class EventBuilder {

    private static Logger logger = Logger.getLogger(EventBuilder.class);
    public static final StringHelper stringHelper = new StringHelper();

    /**
     * Builds an event from command line arguments
     * @param args
     * @return Event
     */
    public Event build(String[] args,Configuration configuration) {
        if (isEventValid(args)) {
            String[] cleanedArgs = cleanArgs(args);
            boolean showDetails = Boolean.valueOf(configuration.getShowDetails());
            if(isOtherEvent(cleanedArgs[(cleanedArgs.length - 1)])) { // if the last arg starts with http then other event else health rule violation event. (hackish :-/)
                OtherEvent otherEvent = createOtherEvent(cleanedArgs,showDetails);
                return otherEvent;
            }
            else{
                HealthRuleViolationEvent event = createHealthRuleViolationEvent(cleanedArgs,showDetails);
                return event;
            }
        }
        logger.error("Event is not valid. Args passed are ::" + args);
        return null;
    }

    private OtherEvent createOtherEvent(String[] cleanedArgs, boolean showDetails) {
        OtherEvent otherEvent = new OtherEvent();
        setBasicEvent(cleanedArgs, otherEvent);
        otherEvent.setEventNotificationTime(cleanedArgs[2]);
        otherEvent.setEventNotificationName(cleanedArgs[6]);
        otherEvent.setEventNotificationId(cleanedArgs[7]);
        otherEvent.setEventNotificationIntervalInMin(cleanedArgs[8]);
        if(showDetails){
            setOtherEventDetails(otherEvent, cleanedArgs);
        }
        otherEvent.setDeepLinkUrl(cleanedArgs[cleanedArgs.length - 1]);
        return otherEvent;
    }

    private void setOtherEventDetails(OtherEvent otherEvent, String[] cleanedArgs) {
        int currentArgPos = 9;
        try {
            int numOfEventTypes = Integer.parseInt(cleanedArgs[currentArgPos]);
            otherEvent.setNumberOfEventTypes(cleanedArgs[currentArgPos]);
            for(int index = 1; index <= numOfEventTypes; index++){
                EventType eventType = new EventType();
                currentArgPos++;
                eventType.setEventType(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eventType.setEventTypeNum(cleanedArgs[currentArgPos]);
                otherEvent.getEventTypes().add(eventType);
            }
            setEventSummary(otherEvent, cleanedArgs, currentArgPos);
        }
        catch(NumberFormatException nfe){
            logger.error("Cannot convert string to int because of mismatch of arguments ",nfe);
        }
    }

    private void setEventSummary(OtherEvent otherEvent, String[] cleanedArgs, int currentArgPos) {
        currentArgPos++;
        try {
            int numberOfEventSummaries = Integer.parseInt(cleanedArgs[currentArgPos]);
            otherEvent.setNumberOfEventSummaries(cleanedArgs[currentArgPos]);
            for (int index = 1; index <= numberOfEventSummaries; index++) {
                EventSummary eventSummary = new EventSummary();
                currentArgPos++;
                eventSummary.setEventSummaryId(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eventSummary.setEventSummaryTime(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eventSummary.setEventSummaryType(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eventSummary.setEventSummarySeverity(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eventSummary.setEventSummaryString(cleanedArgs[currentArgPos]);
                otherEvent.getEventSummaries().add(eventSummary);
            }
        }
        catch(NumberFormatException nfe){
            logger.error("Cannot convert string to int because of mismatch of arguments ",nfe);
        }
    }

    private boolean isEventValid(String[] args) {
        //TODO kunal.gupta check if this condition makes sense
        if(args != null && args.length > 16){
            return true;
        }
        return false;
    }

    private HealthRuleViolationEvent createHealthRuleViolationEvent(String[] cleanedArgs,boolean showDetails) {
        HealthRuleViolationEvent event = new HealthRuleViolationEvent();
        setBasicEvent(cleanedArgs, event);
        event.setPvnAlertTime(cleanedArgs[2]);
        event.setHealthRuleName(cleanedArgs[6]);
        event.setHealthRuleID(cleanedArgs[7]);
        event.setPvnTimePeriodInMinutes(cleanedArgs[8]);
        event.setAffectedEntityType(cleanedArgs[9]);
        event.setAffectedEntityName(cleanedArgs[10]);
        event.setAffectedEntityID(cleanedArgs[11]);
        if(showDetails){
            setEvaluationDetails(event,cleanedArgs);
        }
        event.setSummaryMessage(cleanedArgs[cleanedArgs.length - 4]);
        event.setIncidentID(cleanedArgs[cleanedArgs.length - 3]);
        event.setDeepLinkUrl(cleanedArgs[cleanedArgs.length - 2]);
        event.setEventType(cleanedArgs[cleanedArgs.length - 1]);
        return event;
    }

    private void setBasicEvent(String[] cleanedArgs, Event event) {
        event.setAppName(cleanedArgs[0]);
        event.setAppID(cleanedArgs[1]);
        event.setPriority(cleanedArgs[3]);
        event.setSeverity(cleanedArgs[4]);
        event.setTag(cleanedArgs[5]);
    }

    private int setEvaluationDetails(HealthRuleViolationEvent event, String[] cleanedArgs) {
        int currentArgPos = 12;
        try {
            int numOfEvaluationEntities = Integer.parseInt(cleanedArgs[12]);
            for(int index = 1; index <= numOfEvaluationEntities; index++){
                EvaluationEntity eval = new EvaluationEntity();
                currentArgPos++;
                eval.setType(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eval.setName(cleanedArgs[currentArgPos]);
                currentArgPos++;
                eval.setId(cleanedArgs[currentArgPos]);
                currentArgPos = setTriggeredConditionDetails(eval,cleanedArgs,currentArgPos);
                event.getEvaluationEntity().add(eval);
            }
        }
        catch(NumberFormatException nfe){
            logger.error("Cannot convert string to int because of mismatch of arguments ",nfe);
        }
        return currentArgPos;
    }

    private int setTriggeredConditionDetails(EvaluationEntity eval, String[] cleanedArgs, int currentArgPos) {
        try{
            currentArgPos++;
            int numOfTriggeredCond = Integer.parseInt(cleanedArgs[currentArgPos]);
            eval.setNumberOfTriggeredConditions(cleanedArgs[currentArgPos]);
            for (int index=1; index <= numOfTriggeredCond; index++){
                TriggerCondition triggerCond = new TriggerCondition();
                currentArgPos++;
                triggerCond.setScopeType(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setScopeName(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setScopeId(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setConditionName(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setConditionId(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setOperator(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setConditionUnitType(cleanedArgs[currentArgPos]);
                if(triggerCond.getConditionUnitType() != null &&  triggerCond.getConditionUnitType().toUpperCase().startsWith("BASELINE")){
                    currentArgPos = setBaseLineDetails(triggerCond,cleanedArgs,currentArgPos);
                }
                currentArgPos++;
                triggerCond.setThresholdValue(cleanedArgs[currentArgPos]);
                currentArgPos++;
                triggerCond.setObservedValue(cleanedArgs[currentArgPos]);
                eval.getTriggeredConditions().add(triggerCond);
            }
        }
        catch(NumberFormatException nfe){
            logger.error("Cannot convert string to int because of mismatch of arguments", nfe);
        }
        return currentArgPos;
    }

    private int setBaseLineDetails(TriggerCondition triggerCond, String[] cleanedArgs, int currentArgPos) {
        currentArgPos++;
        triggerCond.setUseDefaultBaseline(Boolean.valueOf(cleanedArgs[currentArgPos]));
        if(!triggerCond.isUseDefaultBaseline()){
            currentArgPos++;
            triggerCond.setBaselineName(cleanedArgs[currentArgPos]);
            currentArgPos++;
            triggerCond.setBaselineId(cleanedArgs[currentArgPos]);
        }
        return currentArgPos;
    }


    private String[] cleanArgs(String[] args){
        StringBuilder sb = new StringBuilder();
        String[] stripped = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            sb.append("args[" + i + "]=" + args[i] + ", ");
            stripped[i] = stringHelper.stripQuote(args[i]);
        }
        logger.debug(sb.toString());
        return stripped;
    }

    private boolean isOtherEvent(String eventType) {
        if (eventType != null) {
            return eventType.startsWith("http")  || eventType.startsWith("https");
        }
        return false;
    }
}
