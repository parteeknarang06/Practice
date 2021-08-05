package com.java.threads.map;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadManager {

  private static Logger logger = LogManager.getLogger(ThreadManager.class);
  private static ThreadManager threadManager;

  private final Map<TaskId, ThreadGroup> threadGroups;
  private final AtomicInteger maxThreads = new AtomicInteger(5);

  public ThreadManager() {
    threadGroups = Collections.synchronizedMap(new HashMap<TaskId, ThreadGroup>(5));
  }

  public synchronized static ThreadManager getInstance() {
    if (threadManager == null) {
      threadManager = new ThreadManager();
    }
    return threadManager;
  }

  public ThreadGroup createThreadGroup(TaskId taskId, int workQueue) throws InterruptedException {
    ThreadGroup threadGroup = null;
    unmapThreadGroup();
    if (threadGroups.size() < maxThreads.get()) {
      ExecutorService executorService = new ThreadPoolExecutor(2, 2, Long.MAX_VALUE, TimeUnit.HOURS,
          new ArrayBlockingQueue<Runnable>(workQueue));
      threadGroup = new ThreadGroup(executorService);
      threadGroups.put(taskId, threadGroup);
    }
    return threadGroup;
  }

  private void unmapThreadGroup() throws InterruptedException {
    synchronized (threadGroups) {
      System.out.println(Thread.currentThread().getName()+" get at "+ new Date());
      Iterator<Entry<TaskId, ThreadGroup>> threadIterator = threadGroups.entrySet().iterator();
      while (threadIterator.hasNext()) {
        System.out.println(Thread.currentThread().getName()+" on sleep");
        Thread.sleep(15 * 1000);
        Entry<TaskId, ThreadGroup> threadEntry = threadIterator.next();
        TaskId taskId = threadEntry.getKey();
        ThreadGroup threadGroup = threadEntry.getValue();
        ExecutorService service = threadGroup.getExecutorService();
        System.out.println(Thread.currentThread().getName()+" on awake");
      }
      System.out.println(Thread.currentThread().getName()+" fetch at "+ new Date());
    }
  }

  public ThreadGroup getThreadGroup(TaskId taskId) {
    System.out.println(Thread.currentThread().getName()+" get at "+ new Date());
    ThreadGroup t = threadGroups.get(taskId);
    System.out.println(Thread.currentThread().getName()+" fetch at "+ new Date());
    return t;
  }

}
