package com.xnyesf.opinion.util.thread;

import java.util.concurrent.Callable;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 0:47
 */
public class TaskExecutor {
    private static volatile TaskExecutor instance;
    private final ThreadPoolManager threadPoolManager;

    private TaskExecutor() {
        this.threadPoolManager = ThreadPoolManager.getInstance();
    }
    public static TaskExecutor getInstance() {
        if (instance == null) {
            synchronized (TaskExecutor.class) {
                if (instance == null) {
                    instance = new TaskExecutor();
                }
            }
        }
        return instance;
    }

    public <T> String executeAsync(Callable<T> task, AsyncCallback<T> callback,
                                   TaskWrapper.TaskPriority priority) {
        return threadPoolManager.submitTask(() -> {
            try {
                T result = task.call();
                if (callback != null) {
                    callback.onSuccess(result);
                }
                return result;
            } catch (Exception e) {
                if (callback != null) {
                    callback.onFailure(e);
                }
                throw e;
            }
        }, priority);
    }

    public void shutdown() {
        threadPoolManager.shutdown();
    }
}
