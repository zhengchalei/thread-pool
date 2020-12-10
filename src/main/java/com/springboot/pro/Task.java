package com.springboot.pro;

/**
 * 任务
 *
 * @author xiaoshitou
 * @date 2020/12/09
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            System.out.println("Task 任务被中断了, 因为我接收到了中断信号");
        }
        System.out.println(Thread.currentThread().getName());
    }
}
