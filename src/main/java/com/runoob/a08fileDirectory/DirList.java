package com.runoob.a08fileDirectory;

import java.io.File;
 
public class DirList {

    public static void main(String[] argv) {
        File dir = new File("D:\\a");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("该目录不存在");
        }
        else {
            for (String filename : children) {
                System.out.println(filename);
            }
        }
    }

}