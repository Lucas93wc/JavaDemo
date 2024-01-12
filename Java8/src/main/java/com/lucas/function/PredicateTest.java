package com.lucas.function;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s == null || s.isEmpty();
            }
        };

        System.out.println(predicate.test(null));
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("s"));

        Predicate<String> pred = (String s) -> {return s == null || s.isEmpty();};
        System.out.println(pred.test(null));
        System.out.println(pred.test(""));
        System.out.println(pred.test("s"));
    }
}
