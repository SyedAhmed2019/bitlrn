package com.bitlrn.arrays.stack;

public class Stack {
    public boolean isValid(String s) {
        java.util.Stack stack = new java.util.Stack();
        char[] input = s.toCharArray();
        int i = 0;
        boolean found = true;
        while (i < s.length()) {
            switch (input[i]) {
                case '(':
                case '{':
                case '[':
                    stack.push(input[i]);
                    break;

                case ')':
                case '}':
                case ']':
                    char pop = (Character) stack.pop();
                    if (!(input[i] - pop == 1 || input[i] - pop == 2)) {
                        found = false;
                        break;
                    }
                    break;
            }
            i++;
        }

        return stack.size() == 0 && found;

    }
}
