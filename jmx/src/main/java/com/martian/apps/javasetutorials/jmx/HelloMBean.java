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
public interface HelloMBean {
    
    void setName(String name);
    
    String getName();
    
    void sayHello();
    
}
