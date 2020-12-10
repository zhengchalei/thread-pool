package com.springboot.pro;

import java.util.concurrent.*;

/**
 * 单线程执行器
 *
 * @author xiaoshitou
 * @date 2020/12/09
 */
public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 一个单线程执行的 线程池, 和 newFixedThreadPool 没啥区别, 除了 线程数量可以调节
    }

//    public static ExecutorService newSingleThreadExecutor() {
//        return new Executors.FinalizableDelegatedExecutorService
//                (new ThreadPoolExecutor(1, 1,
//                        0L, TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>()));
//    }


}
