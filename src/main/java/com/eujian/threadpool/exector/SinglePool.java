package com.eujian.threadpool.exector;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池
 * @Author: yeyongjian
 * @Date: 2020-08-04 11:07
 */
public class SinglePool {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i =0;i<10;i++){
            executorService.execute(()->{
                Thread wt = Thread.currentThread();

                String format = String.format("单一线程池，当前线程名称:%s，当前时间：%s", wt.getName(), LocalDateTime.now());
                System.out.println(format);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
