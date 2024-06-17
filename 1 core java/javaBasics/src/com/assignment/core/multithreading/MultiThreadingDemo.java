package com.assignment.core.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class MTDTask implements Runnable {
	static Logger log = LogManager.getLogger(MTDTask.class.getName());
	
    int sleepTime;
    public MTDTask(int sleepTime) {
        this.sleepTime = sleepTime;
    }
    @Override
    public void run() {
    	// Local Variable - Stored in a thread's own stack. Therefore each thread has its own copy. i.e. Changes to local variables in one thread do not affect other threads
    	int localVariable = 0;
    	
        try {
            // Print the state of the current thread
            log.info(Thread.currentThread().getName() + " - State: " + Thread.currentThread().getState());

            // Simulate a task
            for (int i = 0; i < 5; i++) {
                log.info(Thread.currentThread().getName() + " - Count: " + localVariable);
                localVariable += sleepTime;
                Thread.sleep(sleepTime); // Timed Waiting state
            }

        } catch (InterruptedException e) {
            log.error(Thread.currentThread().getName() + " was interrupted.");
        }
        // Print the state of the current thread after finishing
        log.info(Thread.currentThread().getName() + " - State: " + Thread.currentThread().getState());
    }
}

public class MultiThreadingDemo {
	static Logger log = LogManager.getLogger(MultiThreadingDemo.class.getName());
	
    public static void main(String[] args) {

        Thread thread1 = new Thread(new MTDTask(1000), "Thread-1");
        Thread thread2 = new Thread(new MTDTask(2000), "Thread-2");

        // State of the thread before starting
        log.info(thread1.getName() + " - State: " + thread1.getState());
        log.info(thread2.getName() + " - State: " + thread2.getState());

        thread1.start();
        thread2.start();

        // State of the thread after starting
        log.info(thread1.getName() + " - State: " + thread1.getState());
        log.info(thread2.getName() + " - State: " + thread2.getState());

        try {
            thread1.join(); // Main thread waits for thread1 to finish
            thread2.join(); // Main thread waits for thread2 to finish
        } catch (InterruptedException e) {
            log.error("Main thread interrupted.");
        }

        // State of the thread after finishing
        log.info(thread1.getName() + " - State: " + thread1.getState());
        log.info(thread2.getName() + " - State: " + thread2.getState());
    }
}
