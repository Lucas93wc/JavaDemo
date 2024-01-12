package com.lucas.function;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hello");

        Consumer<String> cons = (s) -> System.out.println(s);
        cons.accept("hi");
    }
}
