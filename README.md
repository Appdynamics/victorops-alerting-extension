victorops-alerting-extension
============================
This alerting extension is only meant for on-premise or dedicated controllers.

## Use Case
VictorOps is an on-call management + incident notification platform. The VictorOps alerting extension enables AppDynamics to post AppDynamics events as custom alerts to VictopOps. The payload of the alert has a link to AppDynamics for a thorough diagnosis of the event.

### Prerequisites

- You should have a VictorOps Organization Key and Routing Key

### Steps

1. Run "mvn clean install -DskipTests". You can run the tests by configuring the VictorOps org and routing key in the config.yaml in the test resources folder. 

2. Find the zip file at 'target/victorops-alert.zip' or Download the VictorOps Alerting Extension zip from [AppDynamics Exchange](http://community.appdynamics.com/t5/AppDynamics-eXchange/idb-p/extensions)

3. Unzip the victorops-alert.zip file into <CONTROLLER_HOME_DIR>/custom/actions/ . You should have  <CONTROLLER_HOME_DIR>/custom/actions/victorops-alert created.  

4. Check if you have custom.xml file in <CONTROLLER_HOME_DIR>/custom/actions/ directory. If yes, add the following xml to the <custom-actions> element.

  ```
  <action>
		  <type>victorops-alert</type>
      <!-- For Linux/Unix *.sh -->
 		  <executable>victorops-alert.sh</executable>
      <!-- For windows *.bat -->
 		  <!--<executable>victorops-alert.bat</executable>-->
  </action>
  ```
  If you don't have custom.xml already, create one with the below xml content

  ```
  <custom-actions>
      <action>
  		  <type>victorops-alert</type>
        <!-- For Linux/Unix *.sh -->
   		  <executable>victorops-alert.sh</executable>
        <!-- For windows *.bat -->
   		  <!--<executable>victorops-alert.bat</executable>-->
 	    </action>
    </custom-actions>
  ```
  Uncomment the appropriate executable tag based on windows or linux/unix machine.

5. Update the config.yaml file in <CONTROLLER_HOME_DIR>/custom/actions/victorops-alert/conf/ directory with the Organization Key, Routing Key. You can also configure the level of details sent to VictorOps.
 
###Note
Please make sure to not use tab (\t) while editing yaml files. You may want to validate the yaml file using a yaml     validator http://yamllint.com/

	
  ```
	#VictorOps Org Key
	voOrganizationKey: ""
	
	#VictorOps Routing Key
	voRoutingKey: ""
	
	#scheme used (http/https)
	protocol: "https"
	
	#VictorOps host
	voAlertHost: "alert.victorops.com"
	
	#VictorOps url path
	voAlertUrlPath: "/integrations/generic/20131114/alert"
	
	#http timeouts
	connectTimeout: 10000
	socketTimeout: 10000
	
	#control level of details in VO alert
	showDetails: false
  ```

6. Installing Custom Actions:

      To create a Custom Action, first refer to the the following topics (requires login):
      * [Creating custom action](http://docs.appdynamics.com/display/PRO14S/Custom+Actions)
      * [Build an Alerting Extension](http://docs.appdynamics.com/display/PRO14S/Build+an+Alerting+Extension)

Now you are ready to use this extension as a custom action. In the AppDynamics UI, go to Alert & Respond -> Actions. Click Create Action. Select Custom Action and click OK. In the drop-down menu you can find the action called 'victorops-alert'.

## VictorOps Alert ##
![](https://raw.githubusercontent.com/Appdynamics/victorops-alerting-extension/master/victorops-alert.png?token=7142645__eyJzY29wZSI6IlJhd0Jsb2I6QXBwZHluYW1pY3MvdmljdG9yb3BzLWFsZXJ0aW5nLWV4dGVuc2lvbi9tYXN0ZXIvdmljdG9yb3BzLWFsZXJ0LnBuZyIsImV4cGlyZXMiOjEzOTk2MDI0MTd9--830fafa2ed9a679dd48a4c68de51db5f11a88568)

##Contributing

Find out more in the [AppDynamics Exchange](http://community.appdynamics.com/t5/AppDynamics-eXchange/idb-p/extensions)

##Support

For any questions or feature request, please contact [AppDynamics Center of Excellence](mailto:ace-request@appdynamics.com).

**Version:** 1.0.2
**Controller Compatibility:** 3.7+

