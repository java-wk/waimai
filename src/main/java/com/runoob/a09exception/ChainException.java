package com.runoob.a09exception;

public class ChainException {

    public static void main(String args[]) {
        int n = 20, result;
        try {
            result = n / 0;
            System.out.println("结果为" + result);
        } catch (ArithmeticException ex) {
            System.out.println("发生算术异常: " + ex);
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException ex1) {
                System.out.println("手动抛出链试异常 : " + ex1);
            }
        }
    }

}