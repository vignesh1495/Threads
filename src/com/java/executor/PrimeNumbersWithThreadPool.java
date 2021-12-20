package com.java.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * 
 * Fixed thread pool executor
 * Single threaded executor
 * cached thread pool executor
 * scheduled thread pool executor
 * work stealing thread pool executor
 * 
 * 
 */


import com.java.thread.PrimeNumberUtil;

public class PrimeNumbersWithThreadPool {
	static int number;
	static List<Thread> threads = new ArrayList<Thread>();
	public static void main(String[] args) {
		
	//ExecutorService executorservice = Executors.newFixedThreadPool(3);
	//ExecutorService executorservice = Executors.newCachedThreadPool();
		ThreadPoolExecutor executorserivce = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
		
		Runnable reporterRunnable = ()->{
			System.out.println("running reports");
			System.out.println("Active threads: "+executorserivce.getActiveCount());
			System.out.println("Completed threads: "+executorserivce.getCompletedTaskCount());
		};
		scheduledExecutor.scheduleAtFixedRate(reporterRunnable, 1, 5, TimeUnit.SECONDS);
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n i can tell you the nth prime number. Enter n: ");
			int n = sc.nextInt();
			if (n==0) {
				System.out.println("waiting for all the treads for completion");
				
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
			executorserivce.execute(r);
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

}
