package com.runoob.a07file;

import java.io.File;
 
public class FileRename {

    public static void main(String[] args) {
        File oldName = new File("D:/program.txt");
        File newName = new File("D:/java.txt");
        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("Error");
        }
    }

}