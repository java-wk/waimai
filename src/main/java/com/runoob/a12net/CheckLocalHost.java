package com.runoob.a12net;

import com.alibaba.fastjson.JSON;

import java.net.InetAddress;
 
public class CheckLocalHost {
   public static void main(String[] args) throws Exception {
      InetAddress addr = InetAddress.getLocalHost();

      System.out.println(JSON.toJSONString(addr,true));

      System.out.println("Local HostAddress:"+addr.getHostAddress());
      String hostname = addr.getHostName();
      System.out.println("Local host name: "+hostname);
   }
}