package com.runoob.a12net;

import java.net.URL;
import java.net.URLConnection;
 
public class RemoteFile {
   public static void main(String[] args) throws Exception {
      int size;
      URL url = new URL("http://www.runoob.com/wp-content/themes/runoob/assets/img/newlogo.png");
      URLConnection conn = url.openConnection();
      size = conn.getContentLength();
      if (size < 0)
          System.out.println("无法获取文件大小。");
      else
        System.out.println("文件大小为：" + size + " bytes");
        System.out.println("文件内容为：" + conn.toString());
      conn.getInputStream().close();
   }
}