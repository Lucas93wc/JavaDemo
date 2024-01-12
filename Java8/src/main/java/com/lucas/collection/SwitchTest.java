package com.lucas.collection;

/**
 * @author Lucas
 * @Description TODO
 * @date 2022-01-05 16:03
 */
public class SwitchTest {
    public static void main(String[] args) {
        String str = null;
        switch (str) {
            case "aaa":
                System.out.println("aaa");
                break;
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
        
        System.out.println("done");
    }
}
