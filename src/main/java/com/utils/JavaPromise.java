package com.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static java.util.concurrent.Executors.*;

/**
 * @description:
 * @author: qying
 * @time: 2020/10/26 15:28
 */
public class JavaPromise {
    public static void main(String[] args) throws Throwable, ExecutionException {
        // 两个线程的线程池
        ExecutorService executor = newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("开始执行任务!");
                try {
                    //模拟耗时操作
                    Thread.sleep(20000);
                    System.out.println("我是一个特别耗时的任务");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "耗时任务结束完毕!";
            }
        }, executor);
 
        //采用lambada的实现方式
        future.thenAccept(e -> System.out.println(e + " ok"));
 
        System.out.println("不等上面了，我先跑了");
    }
}