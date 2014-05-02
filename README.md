victorops-alerting-extension
============================
This alerting extension is only meant for on-premise or dedicated controllers.

## Use Case
VictorOps is a on-call management + incident notification platform. The VictorOps alerting extension enables AppDynamics to post health rule violation events as custom alerts to VictopOps. The payload of the alert has a link to AppDynamics for a thorough diagnosis of the event.

### Prerequisites

- You have a VictorOps Organization Key and Routing Key

### Steps

1. Run "mvn clean install"

2. Find the zip file at 'target/victorops-alert.zip' or Download the VictorOps Alerting Extension zip from [AppDynamics Exchange](http://community.appdynamics.com/t5/AppDynamics-eXchange/idb-p/extensions)

3. Unzip the victorops-alert.zip file into <CONTROLLER_HOME_DIR>/custom/actions/ . You should have  <CONTROLLER_HOME_DIR>/custom/actions/victorops-alert created.  

4. Check if you have custom.xml file in <CONTROLLER_HOME_DIR>/custom/actions/ directory. If yes, add the following xml to the <custom-actions> element.
  ``
  <action>
		  <type>hipchat-alert</type>
      <!-- For Linux/Unix *.sh -->
 		  executable>victorops-alert.sh</executable 
      <!-- For windows *.bat -->
 		  <!--<executable>victorops-alert.bat</executable>-->
 	</action>
  ``
  If you don't have custom.xml already, create one with the below xml content
  ``
    <custom-actions>
      <action>
  		  <type>hipchat-alert</type>
        <!-- For Linux/Unix *.sh -->
   		  executable>victorops-alert.sh</executable 
        <!-- For windows *.bat -->
   		  <!--<executable>victorops-alert.bat</executable>-->
 	    </action>
    </custom-actions>
  ``
  Uncomment the appropriate executable tag based on windows or linux/unix machine.

5. Update the config.yaml file in <CONTROLLER_HOME_DIR>/custom/actions/victorops-alert/conf/ directory with the Organization Key, Routing Key. You can also configure the level of details sent to VictorOps.


8. Installing Custom Actions:

      To create a Custom Action, first refer to the the following topics (requires login):
      * [Creating custom action](http://docs.appdynamics.com/display/PRO13S/Custom+Actions)
      * [Build an Alerting Extension](http://docs.appdynamics.com/display/PRO13S/Build+an+Alerting+Extension)

Now you are ready to use this extension as a custom action. In the AppDynamics UI, go to Alert & Respond -> Actions. Click Create Action. Select Custom Action and click OK. In the drop-down menu you can find the action called 'victorops-alert'.

##Contributing

Find out more in the [AppDynamics Exchange](http://community.appdynamics.com/t5/AppDynamics-eXchange/idb-p/extensions)

##Support

For any questions or feature request, please contact [AppDynamics Center of Excellence](mailto:ace-request@appdynamics.com).


