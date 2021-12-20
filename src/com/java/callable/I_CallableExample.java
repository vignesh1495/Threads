package com.java.callable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.java.thread.PrimeNumberUtil;

public class I_CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		ThreadPoolExecutor executorserivce = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
		
	
		List<Future<Integer>> futureobject = new ArrayList<>();
	while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n i can tell you the nth prime number. Enter n: ");
		int n = sc.nextInt();
		if (n==0) {
			System.out.println("waiting for all the treads for completion");
			
		break;
		}
		Callable<Integer> r =new Callable<Integer>() {
			@Override
			public Integer call() {
				return PrimeNumberUtil.calculatePrimenumber(n);
				
			}	
		};
		Future<Integer> primeNumberFuture=executorserivce.submit(r);	
		//System.out.println("the prime number is: "+primeNumberFuture.get());
		futureobject.add(primeNumberFuture);
		
	}
	Iterator<Future<Integer>> iterator = futureobject.iterator();
	while (iterator.hasNext()) {
		Future<Integer> f = iterator.next();
		if (f.isDone()) {
			System.out.println(f.get());
			iterator.remove();
		}
	}
	
	}

}
