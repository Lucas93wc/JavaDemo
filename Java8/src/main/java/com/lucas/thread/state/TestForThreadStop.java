package com.lucas.thread.state;

public class TestForThreadStop implements Runnable {
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName()+ "--->正在运行");
        }
    }

    public void stop() {
        flag = false;
    }

    public static void main(String[] args) {
        TestForThreadStop threadStop = new TestForThreadStop();
        new Thread(threadStop, "线程1").start();
//        threadStop.run();     // 若执行此方法，这意味者主线程在执行run()方法并陷入死循环，无法执行接下来的操作

        for (int i = 0; i < 500; i++) {
            System.out.println("主线程正在运行---"+ i);
            if (i == 366) {
                threadStop.stop();
            }
        }
    }
}
