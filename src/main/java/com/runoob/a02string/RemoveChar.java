package com.runoob.a02string;

public class RemoveChar {
   public static void main(String args[]) {
      String str = "thiss is Java";
      System.out.println(removeCharAt(str, 3));
   }
   private static String removeCharAt(String s, int pos) {
      return s.substring(0, pos) + s.substring(pos + 1);
   }
}