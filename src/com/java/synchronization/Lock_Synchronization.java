package com.java.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.java.thread.CalculatePrime;

class Counter2 implements Runnable {
	
	int value=0;
	private Lock l = new ReentrantLock();
	
	@Override
	public void run() {
	try {
		l.lock();
		this.increments();
		System.out.println(Thread.currentThread().getName()+ " increments "+this.getValue());
		this.decrements();
		System.out.println(Thread.currentThread().getName()+ " decrements "+this.getValue());
		System.out.println("Finished execution: "+this.getValue());
	}finally {
		l.unlock();
	}
		
		
	}

		
	
	
	
	
	public  void increments() {
		value++;
	}
	public   void decrements() {
		value--;
	}
	
	public int getValue() {
		return value;
	}
	
	
	
}



public class Lock_Synchronization {

	public static void main (String[] args) {
			Counter2 counter = new Counter2();
			new Thread(counter).start();
			new Thread(counter).start();
			new Thread(counter).start();
			new Thread(counter).start();
			new Thread(counter).start();
			Counter2 counter2 = new Counter2();
			System.out.println("New Thread");
			new Thread(counter2).start();
	}
}