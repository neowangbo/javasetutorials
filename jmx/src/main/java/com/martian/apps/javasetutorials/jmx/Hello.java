/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javasetutorials.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 *
 * @author b5wang
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean{

    private String name;
    
    @Override
    public void setName(String name) {
        Notification n = new AttributeChangeNotification(this,sequenceNumber++,System.currentTimeMillis(),"Name attribute updated just now!", "name","java.lang.String",this.name, name);
        super.sendNotification(n);
        System.out.println("...send notification!");
        
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, " + name + "!");
    }
    
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        
        System.out.println("...get notification info!");
        String[] types = new String[]{
            AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = 
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
    
    private long sequenceNumber = 1;
}
