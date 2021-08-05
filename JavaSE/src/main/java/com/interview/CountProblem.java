package com.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountProblem {

	public static void main(String[] args) {
		WorkerA w1 =new WorkerA(1, 10);
		WorkerA w2 =new WorkerA(11, 20);
		WorkerA w3 =new WorkerA(21, 30);
		List<WorkerA> list  =new ArrayList<WorkerA>() {{
			add(w1); add(w2); add(w3);
		}};
		List<Future<List<Integer>>> list1 = new ArrayList<>();
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		list.stream().forEach(e->{
			Future<List<Integer>> submit = newFixedThreadPool.submit(e);
			list1.add(submit);
		});
		list1.stream().forEach(e->{
			System.out.println("");
			try {
				e.get().stream().forEach(el->{
					System.out.print(el+" ");
				});
			} catch (InterruptedException | ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		
		newFixedThreadPool.shutdown();
		
	}

}
