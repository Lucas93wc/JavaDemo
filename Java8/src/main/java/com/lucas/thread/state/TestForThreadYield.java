package com.lucas.thread.state;

public class TestForThreadYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        Thread thread = new Thread(myYield, "aaa");
        thread.start();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.yield();
        myYield.run();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i);
        }
    }
}
