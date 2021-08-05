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

public class ThreadPoolExecutorsA {
  
  private static Logger logger = LogManager.getLogger(ThreadPoolExecutorsA.class);
  
  public static void main(String[] args) throws InterruptedException  {
    ThreadPoolExecutor threadPoolExecutor = null;
    List<Future<InterfaceWorkerD>> list = new ArrayList<Future<InterfaceWorkerD>>();
    try {
      ThreadFactory threadFactory = Executors.defaultThreadFactory();
      int corePoolSize = 2;
      int maximumPoolSize = 2;
      long keepAliveTime = Long.MAX_VALUE;
      //WorkerD obj1= new WorkerD();
      //long keepAliveTime = 1;
      int queueSize = 20;
      threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
          new ArrayBlockingQueue<Runnable>(queueSize), threadFactory);
      
      
      
      List<Integer> indexList = new ArrayList<Integer>();
      for (int i =1; i<=10; i++) {
        indexList.add(i);
      }
      for (Integer i :indexList) {
        list.add(threadPoolExecutor.submit(()->{
          InterfaceWorkerD obj= new WorkerD(i);
          obj.start();
          obj.getResult();
          return obj;
        }));
      }
      
      
    } finally {
    //threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
      threadPoolExecutor.shutdown();
    }
    try {
      Thread.sleep(5 * 1000);
      //threadPoolExecutor.shutdownNow();
      for (Future<InterfaceWorkerD> llist:list) {  
        llist.cancel(true);
        //System.out.println("cancel at date:" + new Date());
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("threadPoolExecutor shutdown: "+threadPoolExecutor.isShutdown());
    System.out.println("threadPoolExecutor Terminated: "+threadPoolExecutor.isTerminated());
  }
  
}
