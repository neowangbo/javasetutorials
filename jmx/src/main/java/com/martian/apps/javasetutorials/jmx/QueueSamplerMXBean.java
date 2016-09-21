/*
 * QueueSamplerMXBean.java - MXBean interface describing the management
 * operations and attributes for the QueueSampler MXBean. In this case
 * there is a read-only attribute "QueueSample" and an operation "clearQueue".
 */

package com.martian.apps.javasetutorials.jmx;

public interface QueueSamplerMXBean {
    QueueSample getQueueSample();
    void clearQueue();
}
