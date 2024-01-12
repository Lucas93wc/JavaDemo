package com.lucas.function;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String o) {

                Integer integer = null;
                try {
                    integer = Integer.valueOf(o);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    integer = null;
                }
                return integer;
            }
        };
        System.out.println(function.apply("4"));
        System.out.println(function.apply("s"));

        Function<String, Integer> func = (String o) -> {
            Integer integer = null;
            try {
                integer = Integer.valueOf(o);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                integer = null;
            }
            return integer;
        };
        System.out.println(func.apply("4"));
        System.out.println(func.apply("s"));
    }
}












