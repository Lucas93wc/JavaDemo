package com.lucas.thread.state;

public class TestForThreadJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName()+ "正在执行..." + i);
        }
    }

    public static void main(String[] args) {
        TestForThreadJoin threadJoin = new TestForThreadJoin();
        Thread thread = new Thread(threadJoin, "aaaa");
        thread.start();

        for (int i = 0; i < 200; i++) {
            if (i == 100) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ "正在执行..." + i);
        }
    }
}
