package com.runoob.a08fileDirectory;

import java.io.*;
 
class DirFindFile {

   public static void main(String[] args) {
      File dir = new File("D:");
      FilenameFilter filter = new FilenameFilter() {
         public boolean accept
         (File dir, String name) {
            return name.startsWith("a");
        }
      };
      String[] children = dir.list(filter);
      if (children == null) {
         System.out.println("目录不存在或它不是一个目录");
      } 
      else {
         for (int i=0; i < children.length; i++) {
            String filename = children[i];
            System.out.println(filename);
         }
      } 
   }

}