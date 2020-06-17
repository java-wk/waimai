package com.runoob.a11collection;

import java.util.*;

class CollectionsReverse {
    public static void main(String[] args) {
        String[] coins = {"A", "B", "C", "D", "E"};
        List<String> l = new ArrayList<>(Arrays.asList(coins));
        ListIterator<String> liter = l.listIterator();
        System.out.println("反转前");
        while (liter.hasNext())
            System.out.println(liter.next());
        Collections.reverse(l);
        liter = l.listIterator();
        System.out.println("反转后");
        while (liter.hasNext())
            System.out.println(liter.next());
    }
}