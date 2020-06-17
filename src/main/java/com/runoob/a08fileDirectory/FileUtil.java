package com.runoob.a08fileDirectory;

import java.io.File;
 
public class FileUtil {

    public static void main(String[] a) {
        showDir(1, new File("d:\\a"));
    }

    static void showDir(int indent, File file) {
        for (int i = 0; i < indent; i++)
            System.out.print('-');
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File value : files) {
                showDir(indent + 2, value);
            }
        }
    }

}