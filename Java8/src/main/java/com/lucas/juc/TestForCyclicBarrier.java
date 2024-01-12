package com.lucas.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestForCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(7, () -> System.out.println("召唤神龙!!!"));

        for (int i = 0; i < 7; i++) {
            final int j = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "---->" + j);
                
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
