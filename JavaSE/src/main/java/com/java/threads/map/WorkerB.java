package com.java.threads.map;

public class WorkerB extends Thread {

  private final TaskId taskId;

  public WorkerB(TaskId taskId) {
    this.taskId = taskId;
  }

  @Override
  public void run() {
    try {
      ThreadManager.getInstance().createThreadGroup(taskId, 20);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
