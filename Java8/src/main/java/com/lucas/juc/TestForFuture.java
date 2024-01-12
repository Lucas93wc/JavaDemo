package com.lucas.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestForFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " runAsync");
        });
        System.out.println("111111111");
        completableFuture.get();

        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> {
            int i = 10 / 0;
            return 1024;
        });
        System.out.println(supplyAsync.whenComplete((t, u) -> {
            System.out.println("t==>" + t);
            System.out.println("u==>" + u);
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return -1;
        }).get());
    }
}




