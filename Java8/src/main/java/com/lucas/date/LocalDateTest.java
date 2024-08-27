package com.lucas.date;

import java.time.LocalDate;

public class LocalDateTest {
    public static void main(String[] args) {
        localDateTest1();
    }

    public static void localDateTest1() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonth = now.minusMonths(1);
        LocalDate twoMonthsAgo = now.minusMonths(2);

        // 打印结果
        System.out.println("当前日期: " + now);
        System.out.println("上个月: " + lastMonth);
        System.out.println("上上个月: " + twoMonthsAgo);

    }
}
