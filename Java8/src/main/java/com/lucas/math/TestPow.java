package com.lucas.math;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-12-08 11:03
 */
public class TestPow {
    public static void main(String[] args) {
        String unit = "KB";

        double a = unit.charAt(0) - 'B';
        double value = Math.pow(1024, unit.charAt(0) - 'B');
        System.out.println("a = "+ a);
        System.out.println("value = "+ String.valueOf(value));
    }
}
