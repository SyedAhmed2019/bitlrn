package com.bitlrn.dgio.stack;


/**
 * Given a string, write a function that uses a stack to reverse the string.
 * The function should return the reversed string.
 */
public class StringReverser {

    public static void main(String[] args) {
        String input = "abcd";
        StringReverser sr = new StringReverser();
        System.out.println(sr.reverseString(input));
    }

    public String reverseString(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>(s.length());
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        s = "";
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        return s;
    }
}
