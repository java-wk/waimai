package com.runoob.a11collection;

import java.util.Enumeration;
import java.util.Hashtable;

public class EnumerationIterator {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("1", "One");
        hashtable.put("2", "Two");
        hashtable.put("3", "Three");
        Enumeration<String> e = hashtable.keys();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement());
        }
        System.out.println();
    }

}