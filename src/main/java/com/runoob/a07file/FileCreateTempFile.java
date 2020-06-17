package com.runoob.a07file;

import java.io.File;
 
public class FileCreateTempFile {

    public static void main(String[] args) throws Exception {
        File file;
        File dir = new File("D:/");
        file = File.createTempFile("JavaTemp", ".javatemp", dir);
        System.out.println(file.getPath());
    }

}