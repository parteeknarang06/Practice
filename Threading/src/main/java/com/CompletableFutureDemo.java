package com;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    CompletableFuture<String> completableFuture= new CompletableFuture<String>();
    Executors.newCachedThreadPool().submit(()->{
      try {
        Thread.sleep(5 *1000);
        completableFuture.complete("hello");
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    });
    System.out.println(completableFuture.get());
    
    CompletableFuture<Void> thenAccept = CompletableFuture.supplyAsync(()->{
      try {
        Thread.sleep(5 *1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return "supplyAsync";
    }).thenApply(order->{
      try {
        Thread.sleep(5 *1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return "apply1 complete";
    }).thenAccept(order->{
      System.out.println("accepted");
    });
    //System.out.println(thenApply.get());
  }

  
}
