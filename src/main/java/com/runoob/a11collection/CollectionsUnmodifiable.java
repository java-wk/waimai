package com.runoob.a11collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsUnmodifiable {
    public static void main(String[] argv) {
        List<String> stuff = Arrays.asList("a", "b");
        List list = new ArrayList<>(stuff);
        list = Collections.unmodifiableList(list);
        try {
            list.set(0, "new value");
        } catch (UnsupportedOperationException ignored) {
        }
        Set set = new HashSet<>(stuff);
        set = Collections.unmodifiableSet(set);
        Map map = new HashMap();
        map = Collections.unmodifiableMap(map);
        System.out.println("集合现在是只读");
    }
}