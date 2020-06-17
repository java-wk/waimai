package com.runoob.a10dataStruc;

public class StringReverserThroughStack {
    private final String input;

    public StringReverserThroughStack(String in) {
        input = in;
    }

    public String doRev() {
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.push(ch);
        }
        StringBuilder output = new StringBuilder();
        while (!theStack.isEmpty()) {
            char ch = theStack.pop();
            output.append(ch);
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "www.w3cschool.cc";
        String output;
        StringReverserThroughStack theReverser =
                new StringReverserThroughStack(input);
        output = theReverser.doRev();
        System.out.println("反转前： " + input);
        System.out.println("反转后： " + output);
    }

    static class Stack {
        private final char[] stackArray;
        private int top;

        public Stack(int max) {
            stackArray = new char[max];
            top = -1;
        }

        public void push(char j) {
            stackArray[++top] = j;
        }

        public char pop() {
            return stackArray[top--];
        }

        public char peek() {
            return stackArray[top];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }
}