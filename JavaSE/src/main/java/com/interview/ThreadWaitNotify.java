package com.interview;

class Customer {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.amount -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		System.out.println("deposit completed... ");
		notify();
	}
}

public class ThreadWaitNotify {
	public static void main(String args[]) throws InterruptedException {
		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		Thread.sleep(5*1000);
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}
}