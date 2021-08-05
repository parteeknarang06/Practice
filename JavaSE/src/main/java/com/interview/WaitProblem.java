package com.interview;

import java.util.ArrayList;
import java.util.List;

public class WaitProblem {

	public static void main(String[] args) throws InterruptedException {
		//WorkerB w1 =new WorkerB("w1", 1, 10, true);
		WorkerB w2 =new WorkerB("w2", 11, 20, true);
		WorkerC w3 =new WorkerC("w3", 21, 30, false);
		
//		Thread th1 = new Thread(w1);
//		th1.setName(w1.getName1());
//		th1.start();
		
		Runnable th2 = new Runnable() {
			public void run() {
				w2.run();
			}
		};
		Thread th1 = new Thread(th2);
		th1.setName(w2.getName1());
		th1.start();
		
		
		Thread.sleep(5 *1000);
		Runnable th3 = new Runnable() {
			public void run() {
				w3.run();
			}
		};
		
		Thread th4 = new Thread(th3);
		th4.setName(w3.getName1());
		th4.start();
		
	}

}
