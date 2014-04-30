package com.appdynamics.extensions.victorops.common;


public class StringHelper {

    public String stripQuote(String str){
        if(str != null){
            return str.replaceAll("\"","");
        }
        return str;
    }

}
