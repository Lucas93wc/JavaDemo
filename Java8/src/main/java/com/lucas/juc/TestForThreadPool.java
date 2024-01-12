package com.lucas.juc;

import java.util.concurrent.*;

public class TestForThreadPool {
    public static void main(String[] args) {
        test01();

    }

    public static void test01() {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor = Executors.newCachedThreadPool();

        ExecutorService executor = new ThreadPoolExecutor(2, 5, 3,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                executor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "=========");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
