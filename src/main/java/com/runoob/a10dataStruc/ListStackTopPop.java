package com.runoob.a10dataStruc;

import java.util.*;

public class ListStackTopPop {
    private final LinkedList<Object> list = new LinkedList<>();

    public void push(Object v) {
        list.addFirst(v);
    }

    public Object top() {
        return list.getFirst();
    }

    public Object pop() {
        return list.removeFirst();
    }

    public static void main(String[] args) {
        ListStackTopPop stack = new ListStackTopPop();
        for (int i = 30; i < 40; i++)
            stack.push(i);
        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}