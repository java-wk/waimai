package com.utils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * @author weike
 * @description
 * @date created at 2020/12/24 15:29
 **/
public class FutureThread {

    private Future longTimeMethod2() {
        //创建线程池
        ExecutorService threadPool = newCachedThreadPool();
        //获取异步Future对象
        Future future = threadPool.submit(new Callable() {
            @Override
            public Integer call() throws Exception {
//                return longTimeMethod();
                return null;
            }
        });
        return future;
    }



}
