package com.lucas.thread.syn;

public class UnsafeBuyTicket implements Runnable{
    private int tickets = 15;

    @Override
    public void run() {
        while (tickets > 0) {
            buyTicket();
        }
    }

    public synchronized void buyTicket() {
        if (tickets <= 0) return;

        System.out.println(Thread.currentThread().getName()+"买到了第"+tickets--+"张票");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeBuyTicket ticket = new UnsafeBuyTicket();
        new Thread(ticket, "thread1").start();
        new Thread(ticket, "thread2").start();
        new Thread(ticket, "thread3").start();
    }
}