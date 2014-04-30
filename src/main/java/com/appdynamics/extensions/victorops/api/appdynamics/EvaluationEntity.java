package com.appdynamics.extensions.victorops.api.appdynamics;


import java.util.ArrayList;
import java.util.List;

public class EvaluationEntity {

    String type;
    String name;
    String id;
    List<TriggerCondition> triggeredConditions = new ArrayList<TriggerCondition>();

}
