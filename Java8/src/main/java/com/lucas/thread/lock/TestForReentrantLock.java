package com.lucas.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestForReentrantLock implements Runnable {
    private int num = 30;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            while (num > 0) {
                System.out.println(num--);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestForReentrantLock testForReentrantLock = new TestForReentrantLock();
        new Thread(testForReentrantLock).start();
        new Thread(testForReentrantLock).start();

    }
}
