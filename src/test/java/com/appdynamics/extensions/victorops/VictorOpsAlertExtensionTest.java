/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extensions.victorops;


import com.appdynamics.extensions.victorops.common.ConfigUtil;
import org.junit.Test;

import java.io.FileNotFoundException;

public class VictorOpsAlertExtensionTest {


    EventArgs eventArgs = new EventArgs();
    ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();

    @Test
    public void canPostHRViolationEventWithMultipleEntityAndTriggerMultipleBaselineToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        VictorOpsAlertExtension alertExtension = new VictorOpsAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline());
    }

    @Test
    public void canPostOtherEventToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        VictorOpsAlertExtension alertExtension = new VictorOpsAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getOtherEvent());
    }

    @Test
    public void canPostHRViolationEventWithMultipleEvalEntityAndTriggerMultipleBaselineNoDetailsToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.noDetails").getFile(),Configuration.class);
        VictorOpsAlertExtension alertExtension = new VictorOpsAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline());
    }


    @Test
    public void canPostOtherEventWithNoDetailsToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml.noDetails").getFile(),Configuration.class);
        VictorOpsAlertExtension alertExtension = new VictorOpsAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getOtherEvent());
    }

}
