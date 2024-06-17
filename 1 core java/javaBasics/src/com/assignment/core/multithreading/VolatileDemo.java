package com.assignment.core.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolatileDemo extends Thread {
	static Logger log = LogManager.getLogger(VolatileDemo.class.getName());
	
	// Declare volatile variable to inform threads that it is being accessed by multiple threads
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            // Task simulation
            try {
                log.info("Running...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Thread " + Thread.currentThread().getName() + " is stopping.");
    }

    public void stopThread() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        log.info("---------------------------------------------------------");
        VolatileDemo thread = new VolatileDemo();
        
        log.info("Thread " + thread.getName() + " is starting.");
        thread.start();
        
        // Main thread put to sleep
        Thread.sleep(3000);
        
        // Stop the thread
        thread.stopThread();
        thread.join();
        
        log.info("Main thread finished.");
    }
}
