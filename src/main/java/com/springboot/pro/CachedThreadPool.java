package com.springboot.pro;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存的线程池
 *
 * @author xiaoshitou
 * @date 2020/12/09
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        // 会无脑创建线程执行任务, 执行完毕60S后会回收
        // 缺点: 无脑创建线程
        // 优点: 任务会直接执行, 如果执行完后, 线程60S内有其他任务可以被复用.
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }
        executorService.shutdown();
    }

//    public static ExecutorService newCachedThreadPool() {
    // 核心线程数为0, 最大线程数为 整形最大值
//        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
    // 线程回收时间为60秒
//                60L, TimeUnit.SECONDS,
    // 队列不存储, 会直接执行
//                new SynchronousQueue<Runnable>());
//    }

}
