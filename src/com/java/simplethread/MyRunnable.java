package com.java.simplethread;

public class MyRunnable implements Runnable {

	int counter =0;

	@Override
	public void run() {
		System.out.println("counter: "+ ++counter);
		
	}
	
	Runnable r=new Runnable() {
		@Override
		public void run() {
			System.out.println("Running");
		}
	};
	
	Runnable r1 = () -> System.out.println("Running r1 thread"); 

	public static void main(String[] args) {
		Runnable run1 = new MyRunnable();
		Thread thread1 = new Thread(run1);
		thread1.start();
		Runnable run2 = new MyRunnable();
		Thread thread2 = new Thread(run2);
		thread2.start();
	}

}
