package com.runoob.a10dataStruc;

import java.util.LinkedList;
 
public class linkedListSet {

   public static void main(String[] a) {
      LinkedList<String> linkedList = new LinkedList<>();
      linkedList.add("B");
      linkedList.add("B");
      linkedList.add("T");
      linkedList.add("H");
      linkedList.add("P");
      System.out.println(linkedList);
      linkedList.set(2, "M");
      System.out.println(linkedList);
   }

}