package com.lucas.thread.syn;

public class UnsafeBank implements Runnable {

    private Account account;
    private Integer money;

    public UnsafeBank(Account account, Integer money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        int xj = 0;

        synchronized (account) {
            while (account.getMoney() - money >= 0) {
                account.setMoney(account.getMoney() - money);
                xj += money;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



        System.out.println(Thread.currentThread().getName()+"余额："+account.getMoney());
        System.out.println(Thread.currentThread().getName()+"现金："+ xj);
    }

    public static void main(String[] args) {
        Account account = new Account("1233", 1000);
        UnsafeBank p1 = new UnsafeBank(account, 200);
        UnsafeBank p2 = new UnsafeBank(account, 300);

        new Thread(p1, "thread1").start();
        new Thread(p2, "thread2").start();
    }
}

class Account {
    private String id;
    private int money;

    public Account(String id, int money) {
        this.id = id;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
