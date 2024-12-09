package com.xnyesf.opinion.util.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author CaoLiangBin
 * @date 2024年12月09日 23:19
 * @description 定时器框架
 */
public class TimeFramework {

    private final ScheduledExecutorService scheduler;

    public TimeFramework(int poolSize) {
        scheduler = Executors.newScheduledThreadPool(poolSize);
    }

    /**
     * delay unit后开始执行定时任务
     * @param task
     * @param delay
     * @param unit
     * @return
     */
    public ScheduledFuture<?> schedule(Runnable task, long delay, TimeUnit unit) {
        return scheduler.schedule(task, delay, unit);
    }

    /**
     * 固定速率任务，延迟 initialDelay unit后执行，每period unit后一次
     * @param task
     * @param initialDelay
     * @param period
     * @param unit
     * @return
     */
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long initialDelay, long period, TimeUnit unit) {
        return scheduler.scheduleAtFixedRate(task, initialDelay, period, unit);
    }

    /**
     * 固定执行任务，延迟 initialDelay unit后执行，每次执行完成后延迟Delay unit后执行
     * @param task
     * @param initialDelay
     * @param delay
     * @param unit
     * @return
     */
    public ScheduledFuture<?> sheduleWithFixedDelay(Runnable task, long initialDelay, long delay, TimeUnit unit) {
        return scheduler.scheduleWithFixedDelay(task, initialDelay, delay, unit);
    }

    /**
     * 关闭定时器
     */
    public void shutdown() {
        scheduler.shutdown();
    }
}
