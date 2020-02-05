package ch14.ex10;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 * Copyright (C) 2019 Yoshiki Shibata. All rights reserved.
 */


/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.<br><br>
 *
 * [Instruction]
 * <ul>
 *  <li> Implement one constructor and three methods. </li>
 *  <li> Don't forget to write a Test program to test this class. </li>
 *  <li> Pay attention to @throws tags in the javadoc. </li>
 *  <li> If needed, you can put "synchronized" keyword to methods. </li>
 *  <li> All classes for implementation must be private inside this class. </li>
 *  <li> Don't use java.util.concurrent package. </li>
 *  <li> Don't use {@link java.lang.Thread#interrupt}  method to stop a thread</li>
 *  </ul>
 *
 *  @author Yoshiki Shibata
 */
public class ThreadPool {
	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize the max size of queue
	 * @param numberOfThreads the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException if either queueSize or numberOfThreads
	 *         is less than 1
	 */

	private Deque<Thread> deque;
	private boolean threadStarted = false;
	private ThreadGroup tg;
	private int queueSize;
	private int numberOfThreads;

	public ThreadPool(int queueSize, int numberOfThreads) {
		if(queueSize < 1) {
			throw new IllegalArgumentException("queueSize needs at least 1.");
		}
		if(numberOfThreads < 1) {
			throw new IllegalArgumentException("queueSize needs at least 1.");
		}
		this.queueSize = queueSize;
		this.numberOfThreads = numberOfThreads;
		deque = new ArrayDeque<Thread>(queueSize);
		tg = new ThreadGroup("Thred Group");
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException if threads has been already started.
	 */
	public void start() {
		if(threadStarted) {
			throw new IllegalStateException("Thread has been already started.");
		}

		threadStarted = true;
		while(deque.isEmpty()) {
			try {
				synchronized(this.deque) {
					wait();
				}
			} catch (InterruptedException e) {}
		}

		//if all thread have used , wait 100 mili sec.
		while(tg.activeCount() >= numberOfThreads) {
			try {
				wait(100);
			} catch (InterruptedException e) {}
		}
		deque.poll().start();
		notifyAll();
	}

	/**
	 * Stop all threads gracefully and wait for their terminations.
	 * All requests dispatched before this method is invoked must complete
	 * and this method also will wait for their completion.
	 *
	 * @throws IllegalStateException if threads has not been started.
	 */
	public void stop() {
		if(!threadStarted) {
			throw new IllegalStateException("Thread has not been started.");
		}
		threadStarted = false;
		notifyAll();
		while(!deque.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool.
	 * run() method will be invoked in the thread. If the queue is full, then
	 * this method invocation will be blocked until the queue is not full.
	 *
	 * @param runnable Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException if runnable is null.
	 * @throws IllegalStateException if this pool has not been started yet.
	 */
	public void dispatch(Runnable runnable) {
		if(runnable == null) {
			throw new NullPointerException("runnable is null.");
		}
		if(!threadStarted) {
			throw new IllegalStateException("Thread has not been started.");
		}
		while(deque.size() >= queueSize) {
			try {
				wait();
				System.out.println("dispatch");
			} catch (InterruptedException e) {}
		}
		deque.add(new Thread(tg,runnable));
		notifyAll();
	}
}