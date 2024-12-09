package com.xnyesf.opinion.util.thread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author CaoLiangBin
 * @date 2024年12月10日 0:41
 * @description 线程池管理
 */
public class ThreadPoolManager {
    private final ExecutorService executorService;
    private final Map<String, TaskWrapper<?>> taskMap;
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final long KEEP_ALIVE_TIME = 60L;

    public ThreadPoolManager() {
        this.executorService = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        this.taskMap = new ConcurrentHashMap<>();
    }

    public <T> String submitTask(Callable<T> task, TaskWrapper.TaskPriority priority) {
        String taskId = generateTaskId();
        TaskWrapper<T> wrapper = new TaskWrapper<>(taskId, task, priority);
        Future<T> future = executorService.submit(task);
        wrapper.setFuture(future);
        taskMap.put(taskId, wrapper);
        return taskId;
    }

    public void cancelTask(String taskId) {
        TaskWrapper<?> wrapper = taskMap.get(taskId);
        if (wrapper != null && wrapper.getFuture() != null) {
            wrapper.getFuture().cancel(true);
            taskMap.remove(taskId);
        }
    }

    public boolean isTaskComplete(String taskId) {
        TaskWrapper<?> wrapper = taskMap.get(taskId);
        return wrapper != null && wrapper.getFuture() != null && wrapper.getFuture().isDone();
    }

    @SuppressWarnings("unchecked")
    public <T> T getTaskResult(String taskId) throws ExecutionException, InterruptedException {
        TaskWrapper<?> wrapper = taskMap.get(taskId);
        if (wrapper != null && wrapper.getFuture() != null) {
            return (T) wrapper.getFuture().get();
        }
        return null;
    }

    public void shutdown() {
        executorService.shutdown();
    }

    private String generateTaskId() {
        return String.valueOf(System.nanoTime());
    }
}
