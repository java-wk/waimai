package com.runoob.a03array;

import java.util.*;
 
public class FillTest {
    public static void main(String[] args) {
        int[] array = new int[6];
        Arrays.fill(array, 100);
        for (int value : array) {
            System.out.println(value);
        }

        System.out.println();

        Arrays.fill(array, 3, 6, 50);
        for (int value : array) {
            System.out.println(value);
        }
    }
}

