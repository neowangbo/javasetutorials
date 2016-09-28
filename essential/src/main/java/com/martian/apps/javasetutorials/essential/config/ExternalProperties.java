/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Load a property file by file path.
 *
 * @author b5wang
 */
public class ExternalProperties {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Get current location
//        FileInputStream in = new FileInputStream("");

//        File f = new File(System.getProperty("java.class.path"));
//        System.out.println("--f=" + f.getAbsolutePath());
//        File dir = f.getAbsoluteFile().getParentFile();
//        String path = dir.toString();
//        System.out.println("--path=" + path);
        //String currentDir = ExternalProperties.class.getProtectionDomain().getCodeSource().get‌​Location().toURI().toString();
        System.out.println("\nLoad file: " + args[0] + "\n");
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(args[0])) {
            props.load(in);
        }
        props.forEach((k, v) -> {
            System.out.println("[" + k + "=" + v + "]");
        });
    }

}
