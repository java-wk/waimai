package com.runoob.a07file;

import java.io.File;
 
public class FileReadOnly {
    public static void main(String[] args) {
        File file = new File("D:/java.txt");
        System.out.println(file.setReadOnly());
        System.out.println(file.canWrite());
        System.out.println(file.setWritable(true));
        System.out.println(file.canWrite());
    }
}

