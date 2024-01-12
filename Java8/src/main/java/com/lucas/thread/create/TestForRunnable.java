package com.lucas.thread.create;

public class TestForRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("子线程 == " + i);
        }
    }

    public static void main(String[] args) {
        TestForRunnable thread1 = new TestForRunnable();
        // 调用start()函数开启线程
        new Thread(thread1, "线程1").start();

        for (int i = 0; i < 500; i++) {
            System.out.println("主线程 == "+ i);
        }
    }
}
