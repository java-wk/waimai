package com.runoob.a10dataStruc;

public class Sum {

    public static void main(String[] args) {

        int limit = 100;
        int sum = 0;
        int i = 1;

        do {
            sum = sum + i;
            i++;
            System.out.println(i + "   " + sum);
        }
        while (i <= limit);
        System.out.println("sum=" + sum);
    }

}