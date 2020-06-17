package com.runoob.a08fileDirectory;

class CurDir {

    public static void main(String[] args) {
        String curDir = System.getProperty("user.dir");
        System.out.println("你当前的工作目录为 :" + curDir);
    }

}