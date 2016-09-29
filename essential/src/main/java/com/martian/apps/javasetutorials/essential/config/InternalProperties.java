/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Load property file from jar file.
 * 
 * @author b5wang
 */
public class InternalProperties {
    
    public static void main(String[] args) throws IOException{
        Properties props = new Properties();
        try (InputStream in = InternalProperties.class.getClassLoader().getResourceAsStream("config/config-example-1.properties")) {
            props.load(in);
        }
        props.forEach((Object k, Object v)->{
            System.out.println("[" + k + " = " + v + "]");
        });
    }
    
}
