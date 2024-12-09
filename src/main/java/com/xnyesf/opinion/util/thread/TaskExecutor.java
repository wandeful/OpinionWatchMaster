package com.xnyesf.opinion.util.thread;

import java.util.concurrent.Callable;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 0:47
 */
public class TaskExecutor {
    private final ThreadPoolManager threadPoolManager;

    public TaskExecutor() {
        this.threadPoolManager = new ThreadPoolManager();
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
