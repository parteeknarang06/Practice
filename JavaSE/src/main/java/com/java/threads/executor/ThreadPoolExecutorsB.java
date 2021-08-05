package com.java.threads.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadPoolExecutorsB {
  private static Logger logger = LogManager.getLogger(ThreadPoolExecutorsB.class);
  
  public static void main(String[] args) throws InterruptedException {
    ThreadPoolExecutor threadPoolExecutor = null;
    try {
      ThreadFactory threadFactory = Executors.defaultThreadFactory();
      int corePoolSize = 2;
      int maximumPoolSize = 2;
      long keepAliveTime = Long.MAX_VALUE;
      //long keepAliveTime = 1;
      int queueSize = 100000;
      threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
          new ArrayBlockingQueue<Runnable>(queueSize), threadFactory);
      //Callable<Double> cal = new WorkerB();
      //Runnable runn = new WorkerC();
      List<Integer> indexList = new ArrayList<Integer>();
      for (int i =1; i<=10; i++) {
        indexList.add(i);
      }
      List<Future<InterfaceWorkerD>> futureList = new ArrayList<>();
      for (Integer i :indexList) {
        Future<InterfaceWorkerD> future =threadPoolExecutor.submit(()->{
          InterfaceWorkerD obj= new WorkerD(i);
          obj.start();
          obj.getResult();
          return obj;
        });
        futureList.add(future);
      } 
      
      
      Thread.sleep(10 * 1000);
      //future.cancel(true);
      //threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS);
      System.out.println("main1 at:"+new Date());
      threadPoolExecutor.shutdownNow();
      System.out.println("main2 at:"+new Date());
      System.out.println(threadPoolExecutor.isShutdown());
      System.out.println(threadPoolExecutor.isTerminated());
      //System.out.println("main end at:"+new Date());
    } finally {
    //threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
      threadPoolExecutor.shutdown();
    }
  }
  
}
