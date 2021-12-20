package com.java.thread;

public class PrimeNumberUtil {
	
	
	public static int calculatePrimenumber(int n) {
	
	int number;
	int numbertobefound;
	int i;
	number=1;
	numbertobefound=0;
	while(numbertobefound <n) {
		number++;
		for (i=2;i<=number && number%i !=0;i++) {
		}
		if (i==number) {
			numbertobefound++;
		}
	}
	return number;
	}

}
