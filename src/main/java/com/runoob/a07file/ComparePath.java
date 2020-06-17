package com.runoob.a07file;

import java.io.File;
 
public class ComparePath {

    public static void main(String[] args) {
        File file1 = new File("D:/file/demo1.txt");
        File file2 = new File("D:/file/demo1.txt");
//        File file3 = new File("D:/java/demo2.txt");
        if(file1.compareTo(file2) == 0) {
            System.out.println("文件路径一致！");
        } else {
            System.out.println("文件路径不一致！");
        }
    }

}