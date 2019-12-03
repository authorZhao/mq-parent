package com.git.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test1 {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long time1 = System.currentTimeMillis();

        long s1 = 0;

        FutureTask<Long> future1 = new FutureTask<Long>(()->{
            long s = 0;
            for (int i = 0; i < 800000000; i++) {
                s = s + i;
            }
            return s;
        });

        FutureTask<Long> future2 = new FutureTask<Long>(()->{
            long s = 0;
            for (int i = 800000000; i < 1000000000; i++) {
                s = s + i;
            }
            return s;
        });

        future1.run();
        future2.run();


        s1 = future1.get()+future2.get();
        long time2 = System.currentTimeMillis();
        System.out.println(s1);
        System.out.println("总耗时"+(time2-time1));

    }

    private static void callback(long i, long j) {
        System.out.println("执行了赋值运算");
        i = j;
    }

}
