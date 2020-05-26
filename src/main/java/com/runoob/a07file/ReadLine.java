package com.runoob.a07file;

import java.io.*;
 
public class ReadLine {
    public static void main(String[] args)  {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test.log"));
            out.write("菜鸟教程");
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("test.log"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
//            System.out.println(str);
        } catch (IOException ignored) {
        }
    }
}