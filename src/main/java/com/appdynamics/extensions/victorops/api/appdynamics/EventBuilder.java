package com.appdynamics.extensions.victorops.api.appdynamics;


import org.apache.log4j.Logger;
import com.appdynamics.extensions.victorops.common.StringHelper;

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
    public Event build(String[] args) {
        if (isEventValid(args) && isHealthRuleViolationEvent(args[(args.length - 1)])) {
            String[] cleanedArgs = cleanArgs(args);
            HealthRuleViolationEvent event = createHealthRuleViolationEvent(cleanedArgs);
            return event;
        }
        logger.error("Event is not valid. Args passed are ::" + args);
        return null;
    }

    boolean isEventValid(String[] args) {
        //TODO kunal.gupta check if this condition makes sense
        if(args != null && args.length > 16){
            return true;
        }
        return false;
    }

    HealthRuleViolationEvent createHealthRuleViolationEvent(String[] cleanedArgs) {
        HealthRuleViolationEvent event = new HealthRuleViolationEvent();
        event.setAppName(cleanedArgs[0]);
        event.setAppID(cleanedArgs[1]);
        event.setPvnAlertTime(cleanedArgs[2]);
        event.setPriority(cleanedArgs[3]);
        event.setSeverity(cleanedArgs[4]);
        event.setTag(cleanedArgs[5]);
        event.setHealthRuleName(cleanedArgs[6]);
        event.setHealthRuleID(cleanedArgs[7]);
        event.setPvnTimePeriodInMinutes(cleanedArgs[8]);
        event.setAffectedEntityType(cleanedArgs[9]);
        event.setAffectedEntityName(cleanedArgs[10]);
        event.setAffectedEntityID(cleanedArgs[11]);
        event.setSummaryMessage(cleanedArgs[cleanedArgs.length - 4]);
        event.setIncidentID(cleanedArgs[cleanedArgs.length - 3]);
        event.setDeepLinkUrl(cleanedArgs[cleanedArgs.length - 2]);
        event.setEventType(cleanedArgs[cleanedArgs.length - 1]);
        return event;
    }


    String[] cleanArgs(String[] args){
        StringBuilder sb = new StringBuilder();
        String[] stripped = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            sb.append("args[" + i + "]=" + args[i] + ", ");
            stripped[i] = stringHelper.stripQuote(args[i]);
        }
        logger.debug(sb.toString());
        return stripped;
    }

    //TODO kunal.gupta fix this hack
    boolean isHealthRuleViolationEvent(String eventType) {
        if (eventType != null) {
            return !eventType.startsWith("http") || !eventType.startsWith("https");
        }
        return false;
    }
}
