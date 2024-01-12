package com.lucas.primitivedata;

/**
 * @author Lucas
 * @Description TODO
 * @date 2022-01-10 10:07
 */
public enum Fruit {
    APPLE("Apple"),
    ORANGE("Orange"),
    BANANA("Banana");

    private Fruit(String fruit) {
        System.out.println("it is constructor: "+ fruit);
    }
}
