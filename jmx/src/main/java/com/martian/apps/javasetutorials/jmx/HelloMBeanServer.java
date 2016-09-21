/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.jmx;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 *
 * @author b5wang
 */
public class HelloMBeanServer {

    public static void main(String[] args) {
        try {
            // Get the Platform MBean Server
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            // Construct the ObjectName for the Hello MBean we will register
            ObjectName mbeanName = new ObjectName("com.martian.apps.javasetutorials.jmx:type=Hello");
            // Init Hell MBean
            Hello mbean = new Hello();
            // Register the MBean into MBean Server
            mbs.registerMBean(mbean, mbeanName);

            // Construct the ObjectName for the QueueSampler MXBean we will register
            ObjectName mxbeanName = new ObjectName("com.martian.apps.javasetutorials.jmx:type=QueueSampler");

            // Create the Queue Sampler MXBean
            Queue<String> queue = new ArrayBlockingQueue<String>(10);
            queue.add("Request-1");
            queue.add("Request-2");
            queue.add("Request-3");
            QueueSampler mxbean = new QueueSampler(queue);

            // Register the Queue Sampler MXBean
            mbs.registerMBean(mxbean, mxbeanName);

            System.out.println("Waiting forever...");
            Thread.sleep(Long.MAX_VALUE);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | InterruptedException ex) {
            Logger.getLogger(HelloMBeanServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
