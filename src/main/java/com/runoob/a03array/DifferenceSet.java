package com.runoob.a03array;

import java.util.ArrayList;
 
public class DifferenceSet {
    public static void main(String[] args)  {
        ArrayList<String> objArray = new ArrayList<>();
        ArrayList<String> objArray2 = new ArrayList<>();
        objArray2.add(0,"common1");
        objArray2.add(1,"common2");
        objArray2.add(2,"notcommon");
        objArray2.add(3,"notcommon1");

        objArray.add(0,"common1");
        objArray.add(1,"common2");
        objArray.add(2,"notcommon2");
        objArray.add(3,"notcommon3");

        ArrayList<String> objArray3 = new ArrayList<>(objArray);
        System.out.println("array1 的元素" +objArray);
        System.out.println("array2 的元素" +objArray2);

        objArray.removeAll(objArray2);
        objArray2.removeAll(objArray3);
        System.out.println("array1 与 array2 数组差集为："+objArray);
        System.out.println("array1 与 array2 数组差集为："+objArray2);
    }
}