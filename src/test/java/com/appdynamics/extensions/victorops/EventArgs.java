package com.appdynamics.extensions.victorops;


import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

public class EventArgs {

    public String[] getHealthRuleViolationEventWithOneEvalEntityAndTriggerNoBaseline(){
        List<String> strings = Lists.newArrayList();
        strings.add("\"MyMacMachineAgent\""); //appname
        strings.add("\"4\""); //appID
        strings.add("\"Wed Apr 30 09:42:55 PDT 2014\""); //pvn alert time
        strings.add("\"1\""); //priority
        strings.add("\"ERROR\""); //severity
        strings.add("\"VictorOpsAction\"");  //tag
        strings.add("\"CPU utilization is too high\"");  //health rule name
        strings.add("\"24\"");  //health rule id
        strings.add("\"1\"");  //pvn time period in min
        strings.add("\"APPLICATION_COMPONENT_NODE\"");  //affected entity type
        strings.add("\"MyMacMachineAgentNode1\""); //affected entity name
        strings.add("\"8\"");  //affected entity id
        strings.add("\"1\"");  //number of eval entities
        strings.add("\"APPLICATION_COMPONENT_NODE\"");   //eval entity type
        strings.add("\"MyMacMachineAgentNode1\""); //eval entity name
        strings.add("\"8\"");  //eval entity id
        strings.add("\"1\"");  //number of triggered cond per eval entity
        strings.add("\"APPLICATION_COMPONENT_NODE\""); //scope type 1
        strings.add("\"MyMacMachineAgentNode1\""); //scope name 1
        strings.add("\"8\"");  //scope id 1
        strings.add("\"Hardware Resources|CPU|%Busy Condition\""); // condition name 1
        strings.add("\"113\"");  //condition id 1
        strings.add("\"GREATER_THAN\"");  //operator 1
        strings.add("\"ABSOLUTE\"");  //condition unit type 1
        strings.add("\"4\"");  //threshhold value 1
        strings.add("\"40.0\"");  //observed value 1
        //summary message
        strings.add("\"CPU utilization is too high triggered at Wed Apr 30 09:42:55 PDT 2014. This policy was violated because the following conditions were met for the MyMacMachineAgentNode1 Node for the last 1 minute(s):   For Evaluation Entity: MyMacMachineAgentNode1 Node - Hardware Resources|CPU|%Busy Condition is greater than 4. Observed value = 40.0\"");  //observed value 1
        strings.add("\"3\"");  //incident id
        strings.add("\"http://WIN-OAR4D8QEG3K:8090/controller/#location=APP_INCIDENT_DETAIL&incident=\"");  //deep link url
        strings.add("\"POLICY_OPEN_CRITICAL\"");  //event type
        return Iterables.toArray(strings,String.class);
    }

    public String[] getHealthRuleViolationEventWithMultipleEvalEntityAndTriggerNoBaseline(){
        return null;
    }


    public String[] getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerNoBaseline(){
        return null;
    }

    public String[] getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline(){
        return null;
    }


}
