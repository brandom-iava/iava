/**
 * QueueSampler.java - MXBean implementation for the QueueSampler MXBean.
 * This class must implement all the Java methods declared in the
 * QueueSamplerMXBean interface, with the appropriate behavior for each one.
 */

package com.iava.base.jmx.mxbeans;

import java.util.Date;
import java.util.Queue;

public class QueueSampler implements QueueSamplerMXBean {
    
    private Queue<String> queue;
    
    public QueueSampler(Queue<String> queue) {
        this.queue = queue;
    }
    
    public QueueSample getQueueSample() {
        synchronized (queue) {
        	System.out.println("1111");
            return new QueueSample(new Date(), queue.size(), queue.peek());
        }
    }
    
    public void clearQueue() {
        synchronized (queue) {
            queue.clear();
        }
    }

	@Override
	public void addToQueue(String tt) {
		// TODO Auto-generated method stub
		synchronized (queue) {
            queue.add(tt);
        }
	}
}
