package com.concept.inheritence;

import com.concept.inheritence.workers.Alarm;
import com.concept.inheritence.workers.Car;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ParentCallChildMethod {

  public static void main(String[] args) {
    Alarm alarm = new Car();
    alarm.trunAlarmOn();
    alarm.automaticAlarmOn();
    
    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);
    blockingQueue.add("1");
    blockingQueue.offer("2");
    //blockingQueue.add("2");
    
  }

}
