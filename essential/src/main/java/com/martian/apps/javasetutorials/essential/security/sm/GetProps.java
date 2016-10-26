/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.security.sm;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The default policy file, java.policy is (by default) located at:<br>
 * Windows: java.home\lib\security\java.policy<br>
 * UNIX: java.home/lib/security/java.policy<br>
 * <br>
 * Note that java.home represents the value of the "java.home" property,<br>
 * which is a system property specifying the directory into which the JRE was installed.<br>
 * Thus if the JRE was installed in the directory named C:\jdk\jre on Windows and /jdk/jre on UNIX.<br>
 *
 * @author shufeng yan
 */
public class GetProps {

    private static final Logger LOGGER = Logger.getLogger(GetProps.class.getName());
    
    public static void main(String[] args) {
        try {
            System.out.println("os.name     : " + System.getProperty("os.name"));
        } catch (SecurityException ex) {
            LOGGER.log(Level.SEVERE, "Get system property [os.name]", ex);
        }
        
        try {
            System.out.println("java.version: " + System.getProperty("java.version"));
        } catch (SecurityException ex) {
            LOGGER.log(Level.SEVERE, "Get system property [java.version]", ex);
        }
        
        try {
            System.out.println("user.home   : " + System.getProperty("user.home"));
        } catch (SecurityException ex) {
            LOGGER.log(Level.SEVERE, "Get system property [user.home]", ex);
        }
    }

}