package com.lucas.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestForReadWriteLock {
    public static void main(String[] args) {
//        MyCache cache = new MyCache();
        MyCacheLock cache = new MyCacheLock();

        for (int i = 0; i < 5; i++) {
            final String s = String.valueOf(i);

            new Thread(() -> {
                cache.put(String.valueOf(s), s);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final String s = String.valueOf(i);

            new Thread(() -> {
                cache.get(String.valueOf(s));
            }, String.valueOf(i)).start();
        }
    }
}

class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写入...");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在读取...");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完毕---" + o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "正在写入...");
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕");
    }

    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "正在读取...");
        Object o = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完毕---" + o.toString());
    }
}

















