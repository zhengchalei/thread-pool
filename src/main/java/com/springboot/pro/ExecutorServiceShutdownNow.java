package com.springboot.pro;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 立即关闭线程池
 *
 * @author xiaoshitou
 * @date 2020/12/10
 */
public class ExecutorServiceShutdownNow {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
           executorService.execute(new Task());
        }
        // runnables 未执行的任务
        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println("剩余待执行任务: " + runnables.size());
    }
}
