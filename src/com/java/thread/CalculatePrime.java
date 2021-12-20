package com.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;



public class CalculatePrime {
	
	int number;
	List<Thread> threads = new ArrayList<Thread>();
	public CalculatePrime() {
		
		Runnable statusReporter = () -> {
			while(true) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printThreads(threads);
			}
		};
		Thread reporterThread = new Thread(statusReporter);
		reporterThread.setDaemon(true);
		reporterThread.start();
		
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n i can tell you the nth prime number. Enter n: ");
				int n = sc.nextInt();
				if (n==0) {
					reporterThread.interrupt();
					System.out.println("waiting for all the treads for completion");
					waitForThreads(threads);
					System.out.println("Total no of the threads found: "+threads.size());
					
				break;
				}
				Runnable r =new Runnable() {
					@Override
					public void run() {
						number =PrimeNumberUtil.calculatePrimenumber(n);
						System.out.println("\n Result: ");
						System.out.println("\n Value of " +n+ "the prime: "+ number );	
					}	
				};
				Thread t = new Thread(r);
				/****if the thread set to SetDaemon, then program ends arbitrarily if the some of the treads running **/
				t.setDaemon(true);
				threads.add(t);
				t.start();
				}
	}
	
	private static void printThreads(List<Thread> threads) {
		System.out.println("\n Thread Status: ");
		threads.forEach(thread -> {
			System.out.print(thread.getState()+" ");
		});
	}

	private static void waitForThreads(List<Thread> threads) {
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	
	public static void main (String[] args) {
		new CalculatePrime();
	}
}

/**************
 *  High Level thread states -  New, Runnable, Blocked, Waiting, Timed Waiting, Terminated
 *  
 * ********************/
