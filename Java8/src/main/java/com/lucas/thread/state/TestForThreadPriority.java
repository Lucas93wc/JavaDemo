package com.lucas.thread.state;

public class TestForThreadPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);

        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(3);
        t4.setPriority(7);
        t5.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"--->" + Thread.currentThread().getPriority());
    }
}
