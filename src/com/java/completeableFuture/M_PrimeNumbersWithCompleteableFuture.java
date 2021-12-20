package com.java.completeableFuture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import com.java.thread.PrimeNumberUtil;

public class M_PrimeNumbersWithCompleteableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException{

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
		CompletableFuture.supplyAsync(()-> PrimeNumberUtil.calculatePrimenumber(n))
		.thenAccept((Integer retvalue) -> System.out.println(retvalue));
				
			}	
		}
		
	

}
