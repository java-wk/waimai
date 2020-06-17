package com.runoob.a08fileDirectory;

import java.io.File;
 
public class ParentDirectory {
    public static void main(String[] args) {
        File file = new File("C:/File/demo.txt");
        String strParentDirectory = file.getParent();
        System.out.println("文件的上级目录为 : " + strParentDirectory);
    }
}