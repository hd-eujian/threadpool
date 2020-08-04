package com.eujian.threadpool.exector;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 缓存线程池
 * @Author: yeyongjian
 * @Date: 2020-08-04 11:07
 */
public class CashPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i =0;;i++){
            executorService.execute(()->{
                Thread wt = Thread.currentThread();

                String format = String.format("缓存线程池，当前线程名称:%s，当前时间：%s", wt.getName(), LocalDateTime.now());
                System.out.println(format);
                try {
                    double d = Math.random();
                    int sleep = (int)(d*5000);
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread.sleep(100);
        }
    }
}
