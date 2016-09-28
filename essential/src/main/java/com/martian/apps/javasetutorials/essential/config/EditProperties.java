/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * How to get input from console<br>
 * https://www.mkyong.com/java/how-to-read-input-from-console-java/<br>
 * 
 * Demonstrate 3 ways to communicate with OS console.
 * 
 * @author b5wang
 */
public class EditProperties {
    
    private static final String MESSAGE = "Input [key=value] or [q] for exit: ";
    
    public static void main(String[] args){
        //System.in.
    }
    
    private static void byBufferedReader(String propPath){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            while(true){
                System.out.println(MESSAGE);
                String in = br.readLine();
                if("q".equalsIgnoreCase(in)){
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EditProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void byScanner(String propPath){
        
    }
    
    private static void byConsole(String propPath){
        
    }
}
