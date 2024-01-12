package com.lucas.inherit;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-12-21 10:33
 */
public class A {
    public void show(A obj) {
        System.out.println("A.show(A)");
    }

    public void show(C obj) {
        System.out.println("A.show(C)");
    }
}
