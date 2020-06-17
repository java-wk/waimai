package com.runoob.a08fileDirectory;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class FileList {
    public static void main(String[] args) {
        File file = new File("D:\\a");  // 当前目录下的 testdir目录
        if (file.isDirectory()) {
            if (Objects.requireNonNull(file.list()).length > 0) {
                System.out.println(Arrays.toString(file.list()));
                System.out.println("目录不为空!");
            } else {
                System.out.println("目录为空!");
            }
        } else {
            System.out.println("这不是一个目录!");
        }
    }
}