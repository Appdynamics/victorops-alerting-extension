package com.appdynamics.extensions.victorops.api;


import com.appdynamics.extensions.victorops.Configuration;
import com.appdynamics.extensions.victorops.VictorOpsAlertExtension;
import com.appdynamics.extensions.victorops.EventArgs;
import com.appdynamics.extensions.victorops.common.ConfigUtil;
import org.junit.Test;

import java.io.FileNotFoundException;

public class VictorOpsAlertExtensionTest {


    EventArgs eventArgs = new EventArgs();
    ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();

    @Test
    public void canPostHRViolationEventWithOneEvalEntityAndTriggerNoBaselineToVictorOps() throws FileNotFoundException {
        Configuration configuration = configUtil.readConfig(this.getClass().getResource("/conf/config.yaml").getFile(),Configuration.class);
        VictorOpsAlertExtension alertExtension = new VictorOpsAlertExtension(configuration);
        alertExtension.processAnEvent(eventArgs.getHealthRuleViolationEventWithMultipleEvalEntityAndMultipleTriggerBaseline());
    }


}
