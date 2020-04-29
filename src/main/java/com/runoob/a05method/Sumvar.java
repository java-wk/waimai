package com.runoob.a05method;

public class Sumvar {
    private static int sumvar(int... intArrays) {
        int sum, i;
        sum = 0;
        for (i = 0; i < intArrays.length; i++) {
            sum += intArrays[i];
        }
        return (sum);
    }

    public static void main(String[] args) {
        int sum = 0;
        sum = sumvar(10, 12, 33);
        System.out.println("数字相加之和为: " + sum);
    }
}