package com.interview;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WorkerA implements Callable<List<Integer>> {

	private int first;
	private int last;

	public WorkerA(int first, int last) {
		this.first = first;
		this.last = last;
	}

	@Override
	public List<Integer> call() throws Exception {
		return IntStream.rangeClosed(first, last).boxed().collect(Collectors.toList());
	}

}
