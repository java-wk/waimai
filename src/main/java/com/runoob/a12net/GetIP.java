package com.runoob.a12net;

import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class GetIP {
    public static void main(String[] args) {

        InetAddress address = null;
        InetAddress addressdev = null;
        InetAddress addresstest = null;
        for (int i = 0; i < 1; i++) {

            try {
                //www.putaoabc.com=140.143.180.245
                //dev.putaoabc.net.cn=154.8.138.91
                //test.putaoabc.net.cn=139.199.133.101
                address = InetAddress.getByName("www.putaoabc.com");
                InetAddress address1 = InetAddress.getByName("www.putaoabc.com");
                InetAddress address2 = InetAddress.getByName("www.putaoabc.com");
                InetAddress address3 = InetAddress.getByName("www.putaoabc.com");
                addressdev = InetAddress.getByName("dev.putaoabc.net.cn");
                addresstest = InetAddress.getByName("test.putaoabc.net.cn");

                System.out.println(address.getHostName() + " = " + address.getHostAddress());
                System.out.println(address1.getHostName() + " = " + address1.getHostAddress());
                System.out.println(address2.getHostName() + "=" + address2.getHostAddress());
                System.out.println(address3.getHostName() + "=" + address3.getHostAddress());

                System.out.println(addressdev.getHostName() + "=" + addressdev.getHostAddress());
                System.out.println(addresstest.getHostName() + "=" + addresstest.getHostAddress());
            } catch (UnknownHostException e) {
                System.exit(2);
            }
        }
        System.exit(0);
    }
}