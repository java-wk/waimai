package com.runoob.a07file;

import java.io.*;

public class Append {
    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("filename"));
            out.write("aString1");
            out.close();

            out = new BufferedWriter(new FileWriter("filename", true));
            out.write("\n");
            out.write("aString2");
            out.close();

            BufferedReader in = new BufferedReader(new FileReader("filename"));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();

        } catch (IOException e) {
            System.out.println("exception occoured" + e);
        }
    }
}