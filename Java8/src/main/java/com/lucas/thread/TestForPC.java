package com.lucas.thread;

// 管程法
public class TestForPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Provider(container).start();
        new Consumer(container).start();
    }
}

// 生产者
class Provider extends Thread {
    SynContainer container;

    public Provider(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
             container.push(new Chicken(i));
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            container.pop();
        }
    }
}

// 产品
class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer {
    Chicken[] chickens = new Chicken[10];

    int count = 0;

    // 生产者放入产品
    public synchronized void push(Chicken chicken) {
        if (count == chickens.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        chickens[count++] = chicken;
        System.out.println("生产了:"+chicken.id);
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized void pop() {
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Chicken chicken = chickens[--count];
        System.out.println("消费了："+chicken.id);
        this.notifyAll();
    }
}







