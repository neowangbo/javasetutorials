/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.jmx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeChangeNotification;
import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 *
 * @author b5wang
 */
public class JMXClient {

    /**
     * Inner class that will handle the notifications.
     */
    public static class ClientListener implements NotificationListener {

        @Override
        public void handleNotification(Notification notification, Object handback) {
            echo("\nReceived notification:");
            echo("\tClassName: " + notification.getClass().getName());
            echo("\tSource: " + notification.getSource());
            echo("\tType: " + notification.getType());
            echo("\tMessage: " + notification.getMessage());
            if (notification instanceof AttributeChangeNotification) {
                AttributeChangeNotification acn
                        = (AttributeChangeNotification) notification;
                echo("\tAttributeName: " + acn.getAttributeName());
                echo("\tAttributeType: " + acn.getAttributeType());
                echo("\tNewValue: " + acn.getNewValue());
                echo("\tOldValue: " + acn.getOldValue());
            }
        }
    }

    /* For simplicity, we declare "throws Exception".
       Real programs will usually want finer-grained exception handling. 
     */
    public static void main(String[] args) {
        try {
            // Create an RMI connector client and
            // connect it to the RMI connector server
            echo("\nCreate an RMI connector client and " + "connect it to the RMI connector server");
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
            // Create listener
            try (JMXConnector jmxc = JMXConnectorFactory.connect(url, null)) {
                // Create listener
                ClientListener listener = new ClientListener();
                
                // Get an MBeanServerConnection
                //
                echo("\nGet an MBeanServerConnection");
                MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
                waitForEnterPressed();
                
                // Get domains from MBeanServer
                //
                echo("\nDomains:");
                String domains[] = mbsc.getDomains();
                Arrays.sort(domains);
                for (String domain : domains) {
                    echo("\tDomain = " + domain);
                }
                waitForEnterPressed();
                
                // Get MBeanServer's default domain
                //
                echo("\nMBeanServer default domain = " + mbsc.getDefaultDomain());
                
                // Get MBean count
                //
                echo("\nMBean count = " + mbsc.getMBeanCount());
                
                // Query MBean names
                //
                echo("\nQuery MBeanServer MBeans:");
                Set<ObjectName> names = new TreeSet<>(mbsc.queryNames(null, null));
                names.stream().forEach((name) -> {
                    echo("\tObjectName = " + name);
                });
                
                waitForEnterPressed();
                
                // ----------------------
                // Manage the Hello MBean
                // ----------------------
                echo("\n>>> Perform operations on Hello MBean <<<");
                
                // Construct the ObjectName for the Hello MBean
                //
                ObjectName mbeanName = new ObjectName("com.martian.apps.javasetutorials.jmx:type=Hello");
                
                // Create a dedicated proxy for the MBean instead of
                // going directly through the MBean server connection
                //
                HelloMBean mbeanProxy
                        = JMX.newMBeanProxy(mbsc, mbeanName, HelloMBean.class, true);
                
                // Add notification listener on Hello MBean
                //
                echo("\nAdd notification listener...");
                mbsc.addNotificationListener(mbeanName, listener, null, null);
                
                // Get CacheSize attribute in Hello MBean
                //
                echo("\nName = " + mbeanProxy.getName());
                
                // Set CacheSize attribute in Hello MBean
                // Calling "reset" makes the Hello MBean emit a
                // notification that will be received by the registered
                // ClientListener.
                //
                mbeanProxy.setName("Tom");
                
                // Sleep for 2 seconds to have time to receive the notification
                //
                echo("\nWaiting for notification...");
                sleep(2000);
                
                // Get CacheSize attribute in Hello MBean
                //
                echo("\nName = " + mbeanProxy.getName());
                
                // Invoke "sayHello" in Hello MBean
                //
                echo("\nInvoke sayHello() in Hello MBean...");
                mbeanProxy.sayHello();
                
                waitForEnterPressed();
                
                // ------------------------------
                // Manage the QueueSampler MXBean
                // ------------------------------
                echo("\n>>> Perform operations on QueueSampler MXBean <<<");
                
                // Construct the ObjectName for the QueueSampler MXBean
                //
                ObjectName mxbeanName
                        = new ObjectName("com.martian.apps.javasetutorials.jmx:type=QueueSampler");
                
                // Create a dedicated proxy for the MXBean instead of
                // going directly through the MBean server connection
                //
                QueueSamplerMXBean mxbeanProxy
                        = JMX.newMXBeanProxy(mbsc, mxbeanName, QueueSamplerMXBean.class);
                
                // Get QueueSample attribute in QueueSampler MXBean
                //
                QueueSample queue1 = mxbeanProxy.getQueueSample();
                echo("\nQueueSample.Date = " + queue1.getDate());
                echo("QueueSample.Head = " + queue1.getHead());
                echo("QueueSample.Size = " + queue1.getSize());
                
                // Invoke "clearQueue" in QueueSampler MXBean
                //
                echo("\nInvoke clearQueue() in QueueSampler MXBean...");
                mxbeanProxy.clearQueue();
                
                // Get QueueSample attribute in QueueSampler MXBean
                //
                QueueSample queue2 = mxbeanProxy.getQueueSample();
                echo("\nQueueSample.Date = " + queue2.getDate());
                echo("QueueSample.Head = " + queue2.getHead());
                echo("QueueSample.Size = " + queue2.getSize());
                
                waitForEnterPressed();
                
                // Close MBeanServer connection
                //
                echo("\nClose the connection to the server");
            }
            echo("\nBye! Bye!");

        } catch (IOException | MalformedObjectNameException | InstanceNotFoundException ex) {
            Logger.getLogger(JMXClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void echo(String msg) {
        System.out.println(msg);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(JMXClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void waitForEnterPressed() {
        try {
            echo("\nPress <Enter> to continue...");
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(JMXClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
