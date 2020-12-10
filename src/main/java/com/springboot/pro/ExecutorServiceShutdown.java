package com.springboot.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 停止线程池
 *
 * @author xiaoshitou
 * @date 2020/12/09
 */
public class ExecutorServiceShutdown {


    public static void main(String[] args) throws InterruptedException {
        // CPU密集型: 线程池数量应该为 CPU 核心数 1-2 倍
        // IO密集型: CPU核心数量 * ( 1 + 平均等待时间 / 平均工作时间 )

        // 关闭时候只是交给线程池停止指令, 已执行和待执行会执行完毕. 后面添加的执行命令会抛出异常 不允许添加新任务
//        executorService.shutdown();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
           executorService.execute(new Task());
        }
        executorService.shutdown();
        System.out.println("isShutdown: " + executorService.isShutdown());
        System.out.println("isTerminated: " + executorService.isTerminated());
        try {
            executorService.execute(new Task());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(3000L);
        System.out.println("isShutdown: " + executorService.isShutdown());
        System.out.println("isTerminated: " + executorService.isTerminated());
        // 3秒后线程池是否已停止
        boolean b = executorService.awaitTermination(3L, TimeUnit.SECONDS);
        System.out.println(b);
    }

}
