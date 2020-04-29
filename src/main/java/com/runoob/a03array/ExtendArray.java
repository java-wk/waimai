package com.runoob.a03array;

import com.alibaba.fastjson.JSON;

public class ExtendArray {
    public static void main(String[] args) {
        String[] names = new String[]{"A", "B", "C"};
        String[] extended = new String[6];
        extended[4] = "D";
        extended[5] = "E";
        System.out.println(JSON.toJSON(names));
        System.out.println(JSON.toJSONString(extended));
        System.arraycopy(names, 0, extended, 0, names.length);
        for (String str : extended) {
            System.out.println(str);
        }
    }
}