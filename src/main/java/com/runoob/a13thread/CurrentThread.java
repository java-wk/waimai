package com.runoob.a13thread;

import com.alibaba.fastjson.JSON;

public class CurrentThread {

    public static void main(String[] args) {

        System.out.println(JSON.toJSONString(Thread.currentThread(),true));

    }


}




