package com.runoob.a07file;

import java.io.*;

public class DeleteFile {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\putao-1\\IdeaProjects\\waimai\\runoob2.txt");

            BufferedWriter out = new BufferedWriter(new FileWriter("runoob2.txt"));
            out.write("菜鸟教程");
            out.close();

            if (file.delete()) {
                System.out.println(file.getName() + " 文件已被删除！");
            } else {
                System.out.println("文件删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}