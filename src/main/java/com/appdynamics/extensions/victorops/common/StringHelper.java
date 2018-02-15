/*
 *   Copyright 2018. AppDynamics LLC and its affiliates.
 *   All Rights Reserved.
 *   This is unpublished proprietary source code of AppDynamics LLC and its affiliates.
 *   The copyright notice above does not evidence any actual or intended publication of such source code.
 *
 */

package com.appdynamics.extensions.victorops.common;


public class StringHelper {

    public String stripQuote(String str){
        if(str != null){
            return str.replaceAll("\"","");
        }
        return str;
    }

}
