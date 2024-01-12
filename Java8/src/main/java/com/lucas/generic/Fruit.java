package com.lucas.generic;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-04 16:40
 */
public class Fruit extends Food {
    public String id;

    public Fruit() {
    }

    public Fruit(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fruit{" +
            "id='" + id + '\'' +
            '}';
    }
}
