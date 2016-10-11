/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author b5wang
 */
public class SystemProperties {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        print3(props);
        System.out.println("\n\n");
        
        
        // There are some self defined
        System.out.println("Receive args from console: " + Arrays.toString(args));
        for(String arg : args){
            System.out.println("System property from [jvm start options]: " + arg + " = " + props.getProperty(arg));
        }
    }
    
    private static void print1(Properties props){
        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("System properties: [" + key + "=" + value + "]");
        }
    }
    
    private static void print2(Properties props){
        props.entrySet().stream().forEach(entry->{
            System.out.println("System properties: [" + entry.getKey() + "=" + entry.getValue() + "]");
        });
    }
    
    private static void print3(Properties props){
        props.forEach((k,v)->{
            System.out.println("System properties: [" + k + "=" + v + "]");
        });
    }

}
