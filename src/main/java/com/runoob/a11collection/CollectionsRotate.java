package com.runoob.a11collection;

import java.util.*;

public class CollectionsRotate {

    public static void main(String[] args) {
        List list = Arrays.asList("one Two three Four five six".split(" "));
        System.out.println("List :" + list);
        Collections.rotate(list, 3);
        System.out.println("rotate: " + list);
    }

}