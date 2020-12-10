package com.springboot.pro;

import java.util.concurrent.*;

/**
 * 固定线程池
 *
 * @author xiaoshitou
 * @date 2020/12/09
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        // 创建一个固定大小的线程池,
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
    }

//    public static ExecutorService newFixedThreadPool(int nThreads) {
//        // 如下, 最大线程数量和核心线程数量都是 传入参数, 如5
//        return new ThreadPoolExecutor(nThreads, nThreads,
//                // 线程存活时间, corePoolSize,maximumPoolSize 都是一致, 所以maximumPoolSize不会小于corePoolSize, 不会被回收, 所以没有意义
//                0L,
//                // 上一个参数存活时间的 时间单位, TimeUnit.MILLISECONDS 表示千分之一秒的时间单位。
//                TimeUnit.MILLISECONDS,
//                // 这里 队列使用的是 LinkedBlockingQueue, 没有容量上限, 会一直将需要执行的 任务 添加到队列中
//                // 如果队列无上限, 可能会 OOM
//                new LinkedBlockingQueue<>());
//    }

    /**
     * 任务
     *
     * @author xiaoshitou
     * @date 2020/12/09
     */
    static class Task implements Runnable{
        int i ;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 输出当前执行线程的名称
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }

}


/**
 * OOM 演示, 具体时间看你机器的内存决定. 我32G等了好久(没跑出来, 内存一直在涨)
 */
//public class FixedThreadPool {
//
//    public static void main(String[] args) {
//        // 创建一个固定大小的线程池,
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            System.out.println("正在添加 " + i);
//            executorService.execute(new Task(i));
//        }
//    }
//
//    /**
//     * 任务
//     *
//     * @author xiaoshitou
//     * @date 2020/12/09
//     */
//    static class Task implements Runnable{
//
//        int i ;
//
//        public Task(int i) {
//            this.i = i;
//        }
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(Long.MAX_VALUE);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            // 输出当前执行线程的名称
//            System.out.println(Thread.currentThread().getName() + "\t" + i);
//        }
//    }
//
//}
