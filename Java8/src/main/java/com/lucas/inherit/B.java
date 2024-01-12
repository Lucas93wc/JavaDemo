package com.lucas.inherit;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-12-21 10:33
 */
public class B extends A {

    @Override
    public void show(A obj) {
        System.out.println("B.show(A)");
    }

    public void call(B obj) {
        System.out.println("B.call(B)");
    }
}
