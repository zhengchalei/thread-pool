package com.springboot.pro;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 周期任务 线程池
 *
 * @author xiaoshitou
 * @date 2020/12/09
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 100; i++) {
            // 时长位 5 秒
            scheduledExecutorService.schedule(new Task(), 5, TimeUnit.SECONDS);
        }
        scheduledExecutorService.shutdown();
        // 解析: 线程最大单位为 5, 周期性每次只会执行5个 Task
        // 100 / 5 = 20; 次  5*20=100秒;
        //
    }

//    public ScheduledThreadPoolExecutor(int corePoolSize) {
    // 核心线程数量, 最大数量 和 CachedThreadPool 一样
//        super(corePoolSize, Integer.MAX_VALUE,
    // 默认时长 10L , 千分之一秒
//                DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,
//                new ScheduledThreadPoolExecutor.DelayedWorkQueue());
//    }

}
