package com.appdynamics.extensions.victorops.api.appdynamics;


import com.appdynamics.extensions.victorops.Configuration;
import com.appdynamics.extensions.victorops.EventArgs;
import com.appdynamics.extensions.victorops.common.ConfigUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class EventBuilderTest {

    EventBuilder eventBuilder = new EventBuilder();
    EventArgs eventArgs = new EventArgs();
    ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();

    @Test
    public void buildHealthRuleViolationEventWithOneEvalEntityAndTriggerNoBaseline() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        String[] args = eventArgs.getHealthRuleViolationEventWithOneEvalEntityAndTriggerNoBaseline();
        Event event = eventBuilder.build(args,configuration);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof HealthRuleViolationEvent);
    }


    @Test
    public void buildHealthRuleViolationEventWithMultipleEvalEntityAndATriggerNoBaseline() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        String[] args = eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndATriggerNoBaseline();
        Event event = eventBuilder.build(args,configuration);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof HealthRuleViolationEvent);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().size() == 2);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().get(0).getTriggeredConditions().size() == 1);
    }

    @Test
    public void buildHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerNoBaseline() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        String[] args = eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline();
        Event event = eventBuilder.build(args,configuration);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof HealthRuleViolationEvent);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().size() == 2);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().get(0).getTriggeredConditions().size() == 2);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().get(1).getTriggeredConditions().size() == 1);
    }


    @Test
    public void buildHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        String[] args = eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline();
        Event event = eventBuilder.build(args,configuration);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof HealthRuleViolationEvent);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().size() == 2);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().get(0).getTriggeredConditions().get(0).getBaselineName() != null);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().get(0).getTriggeredConditions().get(1).getBaselineName() == null);
    }


    @Test
    public void buildHealthRuleViolationEventWithNoDetails() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.noDetails").getFile(),Configuration.class);
        String[] args = eventArgs.getHealthRuleViolationEventWithOneEvalEntityAndTriggerNoBaseline();
        Event event = eventBuilder.build(args,configuration);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof HealthRuleViolationEvent);
        Assert.assertTrue(((HealthRuleViolationEvent) event).getEvaluationEntity().size() == 0);
    }

    @Test
    public void buildOtherEvent() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        String[] args = eventArgs.getOtherEvent();
        Event event = eventBuilder.build(args,configuration);
        Assert.assertTrue(event != null);
        Assert.assertTrue(event instanceof OtherEvent);
        Assert.assertTrue(((OtherEvent) event).getEventTypes().size() == 2);
        Assert.assertTrue(((OtherEvent) event).getEventSummaries().size() == 2);
    }

}
