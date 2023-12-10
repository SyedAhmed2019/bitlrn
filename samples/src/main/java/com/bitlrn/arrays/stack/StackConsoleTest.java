package com.bitlrn.arrays.stack;

public class StackConsoleTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        String s1 = "()[]{}";
        System.out.println(stack.isValid(s1));

        String s2 = "()";
        System.out.println(stack.isValid(s2));

        String s3 = "(]";
        System.out.println(stack.isValid(s3));
    }
}
