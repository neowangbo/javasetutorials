/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.jmx;

/**
 *
 * @author b5wang
 */
public class JMXServerInfo {
    
    public static void main(String[] args){
        /**
         * JMX server info
         */
        System.out.println("Remote access allowed     : " + System.getProperty("com.sun.management.jmxremote"));
        System.out.println("Remote access port        : " + System.getProperty("com.sun.management.jmxremote.port"));
        System.out.println("Remote access authenticate: " + System.getProperty("com.sun.management.jmxremote.authenticate"));
        System.out.println("Remote access ssl         : " + System.getProperty("com.sun.management.jmxremote.authenticate"));
        System.out.println("Remote access hostname    : " + System.getProperty("java.rmi.server.hostname"));
    }
    
}
