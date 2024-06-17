package com.assignment.core.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class TPEDTask implements Runnable {
	static Logger log = LogManager.getLogger(TPEDTask.class.getName());
    private final int taskId;

    public TPEDTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        log.info("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.info("Task " + taskId + " was interrupted.");
        }
        log.info("Task " + taskId + " is completed on thread " + Thread.currentThread().getName());
    }
}

public class ThreadPoolExecutorDemo {
	static Logger log = LogManager.getLogger(ThreadPoolExecutorDemo.class.getName());
	
    public static void main(String[] args) {
        log.info("---------------------------------------------------------");
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the executor
        for (int i = 1; i <= 10; i++) {
            executor.submit(new TPEDTask(i));
        }

        // Shut down the executor
        executor.shutdown();

        try {
        	// Force shutdown if tasks are not completed in time
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        log.info("All tasks are finished.");
    }
}
