package com.eujian.threadpool.exector;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPool {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        String begin = String.format("调度线程池-begin，当前时间：%s",  LocalDateTime.now());
        System.out.println(begin);

//        schedule(pool);
        scheduleAtFixedRate(pool);
//        scheduleWithFixedDelay(pool);


    }

    private static void scheduleAtFixedRate(ScheduledExecutorService pool){
        pool.scheduleAtFixedRate(()->{

            Thread wt = Thread.currentThread();
            String format = String.format("scheduleAtFixedRate-调度线程池，当前线程名称:%s，当前时间：%s", wt.getName(), LocalDateTime.now());
            System.out.println(format);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1,1, TimeUnit.SECONDS);

    }


    private static void scheduleWithFixedDelay(ScheduledExecutorService pool){
        pool.scheduleWithFixedDelay(()->{

            Thread wt = Thread.currentThread();
            String format = String.format("scheduleWithFixedDelay-调度线程池，当前线程名称:%s，当前时间：%s", wt.getName(), LocalDateTime.now());
            System.out.println(format);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1,1, TimeUnit.SECONDS);

    }
    private static void schedule(ScheduledExecutorService pool){
        for (int i =0;i<10;i++){
            pool.schedule(()->{

                Thread wt = Thread.currentThread();
                String format = String.format("调度线程池，当前线程名称:%s，当前时间：%s", wt.getName(), LocalDateTime.now());
                System.out.println(format);
            },5, TimeUnit.SECONDS);

        }
        pool.shutdown();
    }

}
