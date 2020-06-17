package com.runoob.a10dataStruc;

import java.util.*;

public class LinkedListSubListClear {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<>();
        lList.add("1");
        lList.add("8");
        lList.add("6");
        lList.add("4");
        lList.add("5");
        System.out.println(lList);
        lList.subList(2, 4).clear();
        System.out.println(lList);
    }
}