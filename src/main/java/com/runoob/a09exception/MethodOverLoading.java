package com.runoob.a09exception;

public class MethodOverLoading {
    double method(int i) {
        return i / 0;
    }

    boolean method(boolean b) {
        return !b;
    }

    static double method(int x, double y) {
        return x + y;
    }

    static double method(double x, double y) {
        return x + y - 3;
    }

    public static void main(String[] args) {
        MethodOverLoading mn = new MethodOverLoading();
        try {
            System.out.println(method(10, 20.0));
            System.out.println(method(10.0, 20));
            System.out.println(method(10.0, 20.0));
            System.out.println(mn.method(false));
            System.out.println(mn.method(10));
        } catch (Exception ex) {
            System.out.println("exception occur: " + ex);
            ex.printStackTrace();
        }
    }
}
