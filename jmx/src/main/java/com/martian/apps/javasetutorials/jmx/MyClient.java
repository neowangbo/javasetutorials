/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.jmx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.apache.activemq.broker.jmx.QueueViewMBean;

/**
 *
 * @author b5wang
 */
public class MyClient {

    private QueueViewMBean mbean;

    public MyClient() {
        //init
    }

    public void start() throws MalformedURLException, IOException, MalformedObjectNameException, InstanceNotFoundException {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        ObjectName mbeanName = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=org.apache.activemq.spring.Test.spring.embedded");
        mbean = JMX.newMBeanProxy(mbsc, mbeanName, QueueViewMBean.class, true);
    }
    
    public long getMessageNumber(){
        return mbean.getQueueSize();
    }

    @SuppressWarnings("SleepWhileInLoop")
    public static void main(String[] args) {
        try {

            // service:jmx:rmi://[host[:port]][urlPath]
            // service:jmx:rmi:///jndi/rmi://localhost:9999/server
            // service:jmx:rmi://127.0.0.1/stub/
            MyClient client = new MyClient();
            client.start();

            while (true) {
                System.out.println(" --- QueueSize: " + client.getMessageNumber());
                Thread.sleep(10000);
            }
             
        } catch (MalformedURLException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | MalformedObjectNameException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstanceNotFoundException | InterruptedException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
