package com.xnyesf.opinion.util.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 0:39
 * @description 任务包装类
 */
public class TaskWrapper<T>{
    private final String taskId;
    private final Callable<T> task;
    private Future<T> future;
    private TaskPriority priority;

    public enum TaskPriority {
        HIGH, MEDIUM, LOW
    }

    public TaskWrapper(String taskId, Callable<T> task, TaskPriority priority) {
        this.taskId = taskId;
        this.task = task;
        this.priority = priority;
    }

    // getters and setters
    public String getTaskId() { return taskId; }
    public Callable<T> getTask() { return task; }
    public Future<T> getFuture() { return future; }
    public void setFuture(Future<T> future) { this.future = future; }
    public TaskPriority getPriority() { return priority; }
}
