package com.runoob.a11collection;

import java.util.*;
import java.io.*;

public class ArrayToCollection {

    public static void main(String[] args) {
        int n = 5;         // 5 个元素
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = String.valueOf(i);
        }
        List<String> list = Arrays.asList(name);
        System.out.println();
        for (String li : list) {
            System.out.print(li + " ");
        }
    }

}