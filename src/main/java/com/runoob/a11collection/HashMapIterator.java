package com.runoob.a11collection;

import java.util.*;

public class HashMapIterator {

    public static void main(String[] args) {
        HashMap<String, String> hMap = new HashMap<>();
        hMap.put("1", "1st");
        hMap.put("2", "2nd");
        hMap.put("3", "3rd");
        Collection cl = hMap.values();
        Iterator itr = cl.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}