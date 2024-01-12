package com.lucas.function;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello world!";
            }
        };
        System.out.println(supplier.get());

        Supplier<String> supp = () -> "Welcome!";
        System.out.println(supp.get());
    }
}
