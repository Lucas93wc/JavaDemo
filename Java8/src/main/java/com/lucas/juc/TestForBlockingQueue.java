package com.lucas.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class TestForBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
//        test01();
//        test02();
//        test03();
//        test04();
        test05();
    }

    // 同步队列 放入一个，取出一个
    public static void test05() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " put " + "a");
                blockingQueue.put("a");
                System.out.println(Thread.currentThread().getName() + " put " + "b");
                blockingQueue.put("b");
                System.out.println(Thread.currentThread().getName() + " put " + "c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();


        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " take " + "a");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " take " + "b");
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + " put " + "c");
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

    }

    // offer、poll：有返回值，在超出容量时，阻塞线程，等待一定时间后返回;
    public static void test04() throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d", 2, TimeUnit.SECONDS));



        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));
    }

    // put()：无返回值，在超出容量时，阻塞线程一直等待；
    // take()：有返回值，在超出容量时，阻塞线程一直等待；
    public static void test03() throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 阻塞，一直等待
//        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 阻塞，一直等待
//        System.out.println(blockingQueue.take());
    }

    // offer、poll：有返回值，在超出容量时，不会抛出异常
    // 使用peek时：返回队列首位对象值
    public static void test02() {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    // 使用add、remove时：有返回值，在超出容量时，会抛出异常
    // 使用element时：返回队列首位对象值
    public static void test01() {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // java.lang.IllegalStateException: Queue full
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException
//        System.out.println(blockingQueue.remove());
    }
}

















