package com.lucas.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class TestForCAS {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(200);
        boolean set = atomicInteger.compareAndSet(200, 201);

        System.out.println(set + " " +atomicInteger.get());

        AtomicStampedReference<Integer> stampe = new AtomicStampedReference<>(200, 100);

        
    }
}
