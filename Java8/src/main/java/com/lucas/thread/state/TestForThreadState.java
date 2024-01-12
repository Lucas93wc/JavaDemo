package com.lucas.thread.state;

public class TestForThreadState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("完成...........");
        });
        System.out.println(thread.getState());

        thread.start();
        while (thread.getState() != Thread.State.TERMINATED) {
            System.out.println(thread.getState());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(thread.getState());
    }
}
