package com.runoob.a07file;

import java.io.File;
 
public class FileExists {
    public static void main(String[] args) {
        File file = new File("D:/java.txt");
        System.out.println(file.exists());
    }
}