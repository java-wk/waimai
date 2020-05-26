package com.runoob.a05method;

public class Main {
    private static void vaTest(int... no) {
        System.out.println("vaTest(int ...): " + "参数个数: " + no.length + " 内容: ");
        for (int n : no)
            System.out.println(n + " ");
        System.out.println();
    }

    private static void vaTest(boolean... bl) {
        System.out.println("vaTest(boolean ...) " + "参数个数: " + bl.length + " 内容: ");
        for (boolean b : bl)
            System.out.println(b + " ");
        System.out.println();
    }

    private static void vaTest(String msg, int... no) {
        System.out.println("vaTest(String, int ...): " + msg + "参数个数: " + no.length + " 内容: ");
        for (int n : no)
            System.out.println(n + " ");
        System.out.println();
    }


    public static void main(String[] args) {
        vaTest(1, 2, 3);
        vaTest("测试: ", 10, 20);
        vaTest(true, false, false);
    }
}