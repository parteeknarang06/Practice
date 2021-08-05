package com.java.threads.map;

public class WorkerA extends Thread {

  private final TaskId taskId;

  public WorkerA(TaskId taskId) {
    this.taskId = taskId;
  }

  @Override
  public void run() {
    ThreadManager.getInstance().getThreadGroup(taskId);
  }

}
