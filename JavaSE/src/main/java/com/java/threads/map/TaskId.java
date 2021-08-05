package com.java.threads.map;

public final class TaskId {
  private final String taskName;
  private final int taskInstanceId; // Task Instance id from dgController
  private final String taskId; // Task id generated on bigquery idp

  public TaskId(String taskName, int taskInstanceId) {
    this.taskName = (taskName == null ? "" : taskName);
    this.taskInstanceId = taskInstanceId;
    this.taskId = "";
  }

  public TaskId(String taskName, int taskInstanceId, String taskId) {
    this.taskName = (taskName == null ? "" : taskName);
    this.taskInstanceId = taskInstanceId;
    this.taskId = taskId;
  }

  public String getTaskName() {
    return taskName;
  }

  public int getTaskInstanceId() {
    return taskInstanceId;
  }

  public String getTaskId() {
    return taskId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
    result = prime * result + taskInstanceId;
    result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TaskId other = (TaskId) obj;
    if (taskId == null) {
      if (other.taskId != null)
        return false;
    } else if (!taskId.equals(other.taskId))
      return false;
    if (taskInstanceId != other.taskInstanceId)
      return false;
    if (taskName == null) {
      if (other.taskName != null)
        return false;
    } else if (!taskName.equals(other.taskName))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return String.format("%s: %d %s", taskName, taskInstanceId, taskId);
  }
}
