package com.runoob.a11collection;

import java.util.*;

public class CollectionAddSize {
    public static void main(String[] args) {
        System.out.println("集合实例!");
        int size;
        HashSet<String> collection = new HashSet<>();
        String str1 = "Yellow", str2 = "White", str3 = "Green", str4 = "Blue";
        Iterator<String> iterator;
        collection.add(str1);
        collection.add(str2);
        collection.add(str3);
        collection.add(str4);
        System.out.print("集合数据: ");
        iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        size = collection.size();
        if (collection.isEmpty()) {
            System.out.println("集合是空的");
        } else {
            System.out.println("集合长度: " + size);
        }
        System.out.println();
    }
}