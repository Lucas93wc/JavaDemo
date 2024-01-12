package com.lucas.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestForCondition {
    public static void main(String[] args) {
//        Date1 date = new Date1();
//        Date2 date = new Date2();
        Date3 date = new Date3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                date.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                date.decrement();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                date.increment(1);
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                date.decrement(1);
            }
        }, "D").start();
    }
}

class Date1 {
    int num = 0;

    public synchronized void increment() {
//        if (num != 0) {}
        while (num != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        num++;
        System.out.println(Thread.currentThread().getName()+ "--->" + num);
        this.notifyAll();

    }

    public synchronized void decrement() {
        while (num == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        num--;
        System.out.println(Thread.currentThread().getName()+ "--->" + num);
        this.notifyAll();
    }
}

class Date2 {
    int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }

            num++;
            System.out.println(Thread.currentThread().getName()+ "--->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            num--;
            System.out.println(Thread.currentThread().getName()+ "--->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Date3 {
    int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                condition1.await();
            }

            num++;
            System.out.println(Thread.currentThread().getName()+ "--->" + num);
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void increment(int i) {
        lock.lock();
        try {
            while (num != 0) {
                condition3.await();
            }

            num++;
            System.out.println(Thread.currentThread().getName()+ "--->" + num);
            condition4.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (num == 0) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            num--;
            System.out.println(Thread.currentThread().getName()+ "--->" + num);
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(int i) {
        lock.lock();
        try {
            while (num == 0) {
                try {
                    condition4.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            num--;
            System.out.println(Thread.currentThread().getName()+ "--->" + num);
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}














