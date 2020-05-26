package com.runoob.a07file;

import java.io.*;

public class CreateTempFile {


    public static void main(String[] args) {

        File f = null;
        try {
            // 创建临时文件
            f = File.createTempFile("tmp", ".txt", new File("D:/"));
            // 输出绝对路径
            System.out.println("File path: " + f.getAbsolutePath());
            // 终止后删除临时文件
            f.deleteOnExit();

            // 创建临时文件
            f = File.createTempFile("tmp", null, new File("D:/"));
            // 输出绝对路径
            System.out.print("File path: " + f.getAbsolutePath());
            // 终止后删除临时文件
            f.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class TempFile {
        public static void main(String[] args) throws Exception {
            File temp = File.createTempFile("testrunoobtmp", ".txt");
            System.out.println("文件路径: " + temp.getAbsolutePath());
            temp.deleteOnExit();
            BufferedWriter out = new BufferedWriter(new FileWriter(temp));
            out.write("aString");
            System.out.println("临时文件已创建:");
            out.close();
        }

    }

}