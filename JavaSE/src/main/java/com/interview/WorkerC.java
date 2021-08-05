package com.interview;

import java.util.stream.IntStream;

public class WorkerC {

	private String name;
	private int first;
	private int last;
	private boolean wait;
	private Object lock = new Object();

	public WorkerC(String name, int first, int last, boolean wait) {
		this.name = name;
		this.first = first;
		this.last = last;
		this.wait = wait;
	}

	public void run() {
		
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + ": ");
				IntStream.rangeClosed(first, last).forEach(e -> {
					System.out.print(e + " ");
				});
				this.notify();
				System.out.println(Thread.currentThread().getName() + " completed ");
			}
		

	}

	public String getName1() {
		return name;
	}

	

}
