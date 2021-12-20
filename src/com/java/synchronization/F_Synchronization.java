package com.java.synchronization;

import com.java.thread.CalculatePrime;

class Counter implements Runnable {
	
	int value;

	@Override
	public void run() {
		
	synchronized(this) {
		this.increments();
		System.out.println(Thread.currentThread().getName()+ " increments "+this.getValue());
		this.decrements();
		System.out.println(Thread.currentThread().getName()+ " decrements "+this.getValue());
	}
	System.out.println("Finished execution: "+this.getValue());
		
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



public class F_Synchronization {

	public static void main (String[] args) {
			Counter counter = new Counter();
			new Thread(counter).start();
			new Thread(counter).start();
			new Thread(counter).start();
			new Thread(counter).start();
			new Thread(counter).start();
			Counter counter2 = new Counter();
			System.out.println("New Thread");
			new Thread(counter2).start();
	}
}