package com.runoob.net;

import java.net.InetAddress;
 
public class CheckLocalHost {
   public static void main(String[] args) 
   throws Exception {
      InetAddress addr = InetAddress.getLocalHost();
      System.out.println("Local HostAddress:"+addr.getHostAddress());
      String hostname = addr.getHostName();
      System.out.println("Local host name: "+hostname);
   }
}