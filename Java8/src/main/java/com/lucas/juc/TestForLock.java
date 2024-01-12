package com.lucas.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

public class TestForLock {
    List<String> list1 = new ArrayList();
    List<String> list2 = new Vector<>();
    List<String> list3 = Collections.synchronizedList(new ArrayList<>());
    List<String> list4 = new CopyOnWriteArrayList<>();


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Set<String> objects = new CopyOnWriteArraySet<>();
        Map<String, String> map = new ConcurrentHashMap<>();

        System.out.println(Runtime.getRuntime().availableProcessors());

        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sale1();
            }
        }, "aaa").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale1();
            }
        }, "bbb").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.sale1();
            }
        }, "ccc").start();
    }
}

class Ticket{
    int num = 30;

    ReentrantLock lock = new ReentrantLock();

    public synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() +"正在卖出第"+ num +"张票");
            try {
                num--;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"剩余"+ num +"张票!");
        }
    }

    public void sale1() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.print(Thread.currentThread().getName() +"正在卖出第"+ num +"张票,");
                try {
                    num--;
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +"剩余"+ num +"张票!");
            }
        } finally {
            lock.unlock();
        }

    }
}
