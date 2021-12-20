package com.java.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test extends Thread {

//	public void start() {
//		System.out.println("start");
//	}
	
	public void run() {
		System.out.println("run");
	}
	
	public static void main(String[] args) {

		HashMap t = new HashMap();
		t.put(null, 1);
		t.put(3, 2);
		Set s = t.keySet();
		Iterator  iter = s.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
