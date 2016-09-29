/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.essential.config;

import java.util.Map;

/**
 * 1. Windows OS: System env is from System Properties --> environment variables.<br>
 * 2. Linux/Unix: there're several file which is loaded during OS startup.<br>
 * The values can be edited by OS user.<br>
 * @author shufeng yan
 */
public class SystemEnv {
    
    public static void main(String[] args){
        Map<String,String> env = System.getenv();
        env.forEach((String k,String v)->{
            System.out.println("System env: " + k + " = " + v);
        });
    }
    
}
