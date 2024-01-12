package com.lucas.juc;

import java.util.concurrent.TimeUnit;

public class TestForVolatile {
    private  volatile static int  i = 0;
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("before i = "+ i);
            while (i == 0) {

            }
            System.out.println("after i = "+ i);
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        i = 1;

    }
}
