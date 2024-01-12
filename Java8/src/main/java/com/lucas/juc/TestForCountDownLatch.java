package com.lucas.juc;

import java.util.concurrent.CountDownLatch;

public class TestForCountDownLatch {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " - running");
                countDownLatch.countDown();
            } , String.valueOf(i)).start();
        }


        try {
            // 等待计数归零后，才继续执行之后的代码
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
