package com.interview;

import java.util.stream.IntStream;

public class WorkerB {

	private String name;
	private int first;
	private int last;
	private boolean wait;
	private Object lock = new Object();

	public WorkerB(String name, int first, int last, boolean wait) {
		this.name = name;
		this.first = first;
		this.last = last;
		this.wait = wait;
	}

	public synchronized void run() {
		
			synchronized (this) {
				try {
					this.wait();
					System.out.println(Thread.currentThread().getName() + ": ");
					IntStream.rangeClosed(first, last).forEach(e -> {
						System.out.print(e + " ");
					});
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		

	}

	public String getName1() {
		return name;
	}

	

}
