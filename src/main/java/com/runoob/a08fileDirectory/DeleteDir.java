package com.runoob.a08fileDirectory;

import java.io.File;

public class DeleteDir {

    public static void main(String[] argv) {
        // 删除当前目录下的 test 目录
        deleteDir(new File("D:\\a"));
    }

    public static boolean deleteDir(File dir) {

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                boolean success = deleteDir(new File(dir, child));
                if (!success) {
                    return false;
                }
            }
        }

        if (dir.delete()) {
            System.out.println("目录已被删除！");
            return true;
        } else {
            System.out.println("目录删除失败！");
            return false;
        }
    }

}