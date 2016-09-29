/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b5wang
 */
public class XMLProperties {
    
    public static void main(String[] args){
        try(InputStream in = XMLProperties.class.getClassLoader().getResourceAsStream("config/config-example-2.properties")){
            Properties props = new Properties();
            //props.load(in); // can work but the contents are wrong
            props.loadFromXML(in);
            props.forEach((Object k, Object v) -> {
                System.out.println("[" + k + "=" + v + "]");
            });
        } catch (IOException ex) {
            Logger.getLogger(XMLProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
