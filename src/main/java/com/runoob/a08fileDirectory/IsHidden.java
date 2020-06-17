package com.runoob.a08fileDirectory;

import java.io.File;
 
public class IsHidden {
    public static void main(String[] args) {
        File file = new File("D:/Demo.txt");
        System.out.println(file.isHidden());
    }
}