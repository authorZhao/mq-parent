package com.git.thread;

import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        long time1 = System.currentTimeMillis();
        long s1 = 0;
        ExecutorService executor = Executors.newSingleThreadExecutor();


        FutureTask<Long> future1 = new FutureTask<>(()->{
            long s = 0;
            for (int i = 0; i < 800000000; i++) {
                s = s + i;
            }
            throw new RuntimeException("哈哈哈");
            //return s;
        });

        FutureTask<Long> future2 = new FutureTask<>(()->{
            long s = 0;
            for (int i = 800000000; i < 1000000000; i++) {
                s = s + i;
            }
            throw  new RuntimeException("阿萨德");
            //return s;
        });

        Long result=0l;
        FutureTask<Long> future3 = new FutureTask<>(()->{
            long s = 0;
            for (int i = 800000000; i < 1000000000; i++) {
                s = s + i;
            }
            throw  new RuntimeException("aeasf");
            //return s;
        },result);

        //executor.execute(future1);
        //executor.execute(future2);
        //executor.execute(future3);

        executor.submit(future1);
        executor.execute(future2);
        //executor.execute(future3);
        //Future<?> submit = executor.submit(future1);



        s1 = future1.get()+future2.get();
        System.out.println(future3.get());
        long time2 = System.currentTimeMillis();
        System.out.println(s1);
        System.out.println("总耗时"+(time2-time1));
    }


}
