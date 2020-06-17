package com.runoob.a11collection;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
 
class CollectionCompare {

    public static void main(String[] args) {
        String[] coins = { "Penny", "nickel", "dime", "Quarter", "dollar" };
        Set<String> set = new TreeSet<>();
        Collections.addAll(set, coins);
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for (int i = 0; i <= 10; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
    }

}