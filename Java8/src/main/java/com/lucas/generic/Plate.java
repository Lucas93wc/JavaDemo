package com.lucas.generic;

/**
 * @author Lucas
 * @Description TODO
 * @date 2021-06-04 16:45
 */
public class Plate<T> {
    private T item;

    public Plate() {
    }

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
