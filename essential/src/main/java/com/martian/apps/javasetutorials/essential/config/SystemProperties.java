/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.util.Map;
import java.util.Properties;

/**
 *
 * @author b5wang
 */
public class SystemProperties {

    public static void main(String[] args) {
        Properties props = System.getProperties();

        for (Map.Entry<Object, Object> entry : props.entrySet()) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("1 - System properties: [" + key + "=" + value + "]");
        }
        
        props.entrySet().stream().forEach(entry->{
            System.out.println("2 - System properties: [" + entry.getKey() + "=" + entry.getValue() + "]");
        });
        
        props.forEach((k,v)->{
            System.out.println("3 - System properties: [" + k + "=" + v + "]");
        });
    }

}
