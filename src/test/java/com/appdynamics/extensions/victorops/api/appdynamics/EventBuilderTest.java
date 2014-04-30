package com.appdynamics.extensions.victorops.api.appdynamics;


import com.appdynamics.extensions.victorops.EventArgs;
import org.junit.Assert;
import org.junit.Test;

public class EventBuilderTest {

    EventBuilder eventBuilder = new EventBuilder();
    EventArgs eventArgs = new EventArgs();

    @Test
    public void buildHealthRuleViolationEventWithOneEvalEntityAndTriggerNoBaseline(){
        String[] args = eventArgs.getHealthRuleViolationEventWithOneEvalEntityAndTriggerNoBaseline();
        Event event = eventBuilder.build(args);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof HealthRuleViolationEvent);
    }


}
