package com.lucas.inherit;

import com.lucas.inherit.demo1.Son;

/**
 * @author Lucas
 * @Description TODO
 * @date 2023-12-27 15:05
 */
public class Son1 extends Son {
    public static void main(String[] args) {
        Son son = new Son();

        // doGet(java.lang.String, java.lang.String)' has protected access in 'com.lucas.inherit.demo1.Son
//        son.doGet();

        Son1 son1 = new Son1();
        son1.doGet("aaa", "bbb");
    }
}
