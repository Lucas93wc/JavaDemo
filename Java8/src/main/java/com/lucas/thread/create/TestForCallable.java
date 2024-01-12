package com.lucas.thread.create;

import java.util.concurrent.*;

public class TestForCallable implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 200; i++) {
            ;
        }
        System.out.println(Thread.currentThread().getName() + "---执行完毕!");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestForCallable test1 = new TestForCallable();
        TestForCallable test2 = new TestForCallable();
        TestForCallable test3 = new TestForCallable();

        //创建执行服务
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        Future<Boolean> submit1 = threadPool.submit(test1);
        Future<Boolean> submit2 = threadPool.submit(test2);
        Future<Boolean> submit3 = threadPool.submit(test3);

        Boolean r1 = submit1.get();
        Boolean r2 = submit2.get();
        Boolean r3 = submit3.get();

        System.out.println(r1+":"+r2+":"+r3);

        //关闭服务
        threadPool.shutdownNow();
    }
}
