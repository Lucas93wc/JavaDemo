package com.lucas.juc;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class TestForForkJoin extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp = 10000L;

    public TestForForkJoin(Long start, Long end, Long temp) {
        this.start = start;
        this.end = end;
        this.temp = temp;
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            long sum = 0l;
            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        } else {
            long middle = (start + end) / 2;
            TestForForkJoin task1 = new TestForForkJoin(start, middle, temp);
            TestForForkJoin task2 = new TestForForkJoin(middle + 1, end, temp);
            task1.fork();
            task2.fork();

            return task1.join() + task2.join();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Long sum = 0l;
        // 2645左右
//        for (long i = 0l; i < 10_0000_0000l; i++) {
//            sum += i;
//        }

        // 449 左右
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        TestForForkJoin task = new TestForForkJoin(0l, 10_0000_0000l, 1000L);
//        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
//        try {
//            sum = submit.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        // 163 左右
        sum = LongStream.rangeClosed(0l, 10_0000_0000l).parallel().reduce(0, Long::sum);
        long endTime = System.currentTimeMillis();
        System.out.println(sum + " === 花费了："+ (endTime - startTime));
    }
}













