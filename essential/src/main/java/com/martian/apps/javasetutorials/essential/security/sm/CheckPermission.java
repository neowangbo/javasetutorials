/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.security.sm;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shufeng yan
 */
public class CheckPermission {

    public static void main(String[] args) {
        SecurityManager sm = System.getSecurityManager();

        try {
            sm.checkPropertiesAccess();
            Logger.getLogger(CheckPermission.class.getName()).log(Level.INFO, "Has permission of operating System.getProperties()");
        } catch (SecurityException ex) {
            Logger.getLogger(CheckPermission.class.getName()).log(Level.SEVERE, "No permission of operating System.getProperties()", ex);
        }

        // Check permission to access certain key
        try {
            sm.checkPropertyAccess("java.version");
            Logger.getLogger(CheckPermission.class.getName()).log(Level.INFO, "Has permission to get system property [java.version]");
        } catch (SecurityException ex) {
            Logger.getLogger(CheckPermission.class.getName()).log(Level.SEVERE, "No permission to get system property [java.version]", ex);
        }
        
        try {
            sm.checkPropertyAccess("user.home");
            Logger.getLogger(CheckPermission.class.getName()).log(Level.INFO, "Has permission to get system property [user.home]");
        } catch (SecurityException ex) {
            Logger.getLogger(CheckPermission.class.getName()).log(Level.SEVERE, "No permission to get system property [user.home]", ex);
        }
    }

}
