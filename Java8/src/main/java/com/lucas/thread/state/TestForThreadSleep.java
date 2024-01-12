package com.lucas.thread.state;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestForThreadSleep {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        int i = 10;
        while (i >= 0) {
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test02() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        int i = 10;
        while (i-- >= 0) {
            System.out.println(format.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            date = new Date();
        }

    }
}





















