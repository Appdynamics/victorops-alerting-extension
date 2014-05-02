package com.appdynamics.extensions.victorops;

import com.appdynamics.extensions.http.Response;
import com.appdynamics.extensions.victorops.api.appdynamics.Event;
import com.appdynamics.extensions.victorops.api.appdynamics.EventBuilder;
import com.appdynamics.extensions.victorops.api.appdynamics.HealthRuleViolationEvent;
import com.appdynamics.extensions.victorops.api.victorops.Alert;
import com.appdynamics.extensions.victorops.api.victorops.AlertBuilder;
import com.appdynamics.extensions.victorops.common.ConfigUtil;
import com.appdynamics.extensions.victorops.common.HttpHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;

public class VictorOpsAlertExtension {

    public static final String CONFIG_FILENAME =  "." + File.separator + "conf" + File.separator + "config.yaml";
    private static Logger logger = Logger.getLogger(VictorOpsAlertExtension.class);

    //To create the AppDynamics Health Rule Violation event
    final EventBuilder eventBuilder = new EventBuilder();
    //To create a VictorOps alert
    final AlertBuilder alertBuilder = new AlertBuilder();
    //To load the config files
    final static ConfigUtil<Configuration> configUtil = new ConfigUtil<Configuration>();
    //holds the configuration from config.yaml
    Configuration config;

    public static void main(String[] args){
        if(args == null || args.length == 0){
            logger.error("No arguments passed to the extension, exiting the program.");
            return;
        }
        Configuration config = null;
        try {
            config = configUtil.readConfig(CONFIG_FILENAME, Configuration.class);
            VictorOpsAlertExtension alertExtension = new VictorOpsAlertExtension(config);
            int status = alertExtension.processAnEvent(args);
            if(status > 0){
                logger.info( "Victor Ops Extension completed successfully.");
                return;
            }

        } catch (FileNotFoundException e) {
            logger.error( "Config file not found." + e);
        } catch(Exception e){
            logger.error( "Error processing an event" + e);
        }
        logger.error( "Victor Ops Extension completed with errors");
    }


    public VictorOpsAlertExtension(Configuration config){
        String msg = "VictorOpsAlertExtension Version ["+getImplementationTitle()+"]";
        logger.info(msg);
        System.out.println(msg);
        this.config = config;
    }

    /**
     * Creates an AppDynamics health rule event from the command line arguments, builds an VictorOps
     * Alert from the health rule event and posts it to VictorOps.
     * @param args
     * @return -1 incase of an error else 1;
     */
    public int processAnEvent(String[] args) {
        Event event = eventBuilder.build(args,config);
        if (event != null) {
            HealthRuleViolationEvent violationEvent = (HealthRuleViolationEvent) event;
            Alert alert = alertBuilder.buildAlert(violationEvent, config);
            if (alert != null) {
                try {
                    HttpHandler handler = new HttpHandler(config);
                    String json = alertBuilder.convertIntoJsonString(alert);
                    logger.debug("Json posted to VO ::" + json);
                    Response response = handler.postAlert(json);
                    if(response != null && response.getStatus() == HttpURLConnection.HTTP_OK){
                        logger.info( "Data successfully posted to VictorOps");
                        return 1;
                    }
                    logger.error("Data post failed");
                } catch (JsonProcessingException e) {
                    logger.error( "Cannot serialized object into Json." + e);
                }
            }
        }
        return -1;
    }




    private String getImplementationTitle(){
        return this.getClass().getPackage().getImplementationTitle();
    }
}
