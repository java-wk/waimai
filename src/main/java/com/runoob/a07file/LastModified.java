package com.runoob.a07file;

import java.io.File;
import java.util.Date;

public class LastModified {
    public static void main(String[] args) throws Exception {
        File fileToChange = new File("D:/myjavafile.txt");
        boolean newFile = fileToChange.createNewFile();
        Date filetime = new Date(fileToChange.lastModified());

        System.out.println(filetime.toString());

        System.out.println(fileToChange.setLastModified(System.currentTimeMillis()));

        filetime = new Date(fileToChange.lastModified());
        System.out.println(filetime.toString());
    }
}