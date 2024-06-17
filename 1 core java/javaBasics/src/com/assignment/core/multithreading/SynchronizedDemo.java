package com.assignment.core.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Counter {
	private int count = 0;

	public synchronized int increment() {
		return ++count;
	}

	public int getCount() {
		synchronized (this) {
			return count;
		}
	}
}

class IncrementTask implements Runnable {
	static Logger log = LogManager.getLogger(IncrementTask.class.getName());
	private final Counter counter;

	public IncrementTask(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			log.info(Thread.currentThread().getName() + " - Count: " + counter.increment());
		}
	}
}

public class SynchronizedDemo {
	static Logger log = LogManager.getLogger(SynchronizedDemo.class.getName());
	
	public static void main(String[] args) {
        log.info("---------------------------------------------------------");
		Counter counter = new Counter();

		Runnable task = new IncrementTask(counter);

		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			log.info(e.getMessage());
		}

		log.info("Final count: " + counter.getCount());
	}
}
