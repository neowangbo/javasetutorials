/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package com.martian.apps.javasetutorials.essential.config;

import java.util.Arrays;

/**
 * Reference: https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html<br>
 * 
 * @author b5wang
 */
public class CommandLineArguments {
    
    public static void main(String[] args){
        if(args.length > 0){
            System.out.println("Arguments: " + Arrays.toString(args));
        }else{
            System.out.println("No arguments!");
        }
    }
    
}
