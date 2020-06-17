package com.runoob.a08fileDirectory;

import java.io.*;
 
class TraverseDirect {

   public static void main(String[] args) {
      File dir = new File("d:");
      File[] files = dir.listFiles();
      FileFilter fileFilter = new FileFilter() {
         public boolean accept(File file) {
            return file.isDirectory();
         }
      };
      files = dir.listFiles(fileFilter);
      assert files != null;
      System.out.println(files.length);
      if (files.length == 0) {
         System.out.println("目录不存在或它不是一个目录");
      }
      else {
         for (File filename : files) {
            System.out.println(filename.toString());
         }
      }
   }
}