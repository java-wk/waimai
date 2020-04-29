package com.runoob.a03array;

public class Welcome {
    public static void main(String[] args){
        String[] runoobs = new String[3];
        runoobs[0] = "菜鸟教程";
        runoobs[1] = "菜鸟工具";
        runoobs[2] = "菜鸟笔记";
        for (String runoob : runoobs) {
            System.out.print(runoob + " ");
        }
    }
}