package com.java.threads.map;

import java.util.concurrent.ExecutorService;

public class ThreadGroup {

  private final ExecutorService executorService;
  private boolean taskEnded;

  public ThreadGroup(ExecutorService executorService) {
    this.executorService = executorService;
  }

  public ExecutorService getExecutorService() {
    return executorService;
  }

  public boolean isTaskEnded() {
    return taskEnded;
  }

  public void setTaskEnded(boolean taskEnded) {
    this.taskEnded = taskEnded;
  }

}
