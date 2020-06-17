package com.runoob.a08fileDirectory;

import java.io.File;
import java.util.Objects;

public class VisitAllDirsAndFiles {
    public static void main(String[] argv) {
        System.out.println("遍历目录");
        File dir = new File("D://a"); //要遍历的目录
        visitAllDirsAndFiles(dir);
    }
    public static void visitAllDirsAndFiles(File dir) {
        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < Objects.requireNonNull(children).length; i++) {
                visitAllDirsAndFiles(new File(dir, children[i]));
            }
        }
    }
}