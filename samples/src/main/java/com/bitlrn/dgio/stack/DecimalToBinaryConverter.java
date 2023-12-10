package com.bitlrn.dgio.stack;

/**
 * Given a positive integer n, write a function that returns its binary equivalent as a string.
 * The function should not use any in-built binary conversion function.
 */
public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        DecimalToBinaryConverter dbc = new DecimalToBinaryConverter();
        System.out.println(dbc.decimalToBinary(5));
        System.out.println(dbc.decimalToBinary(1024));
    }

    public String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(100);
        // 5 q 2 r 1
        // 2 q 1 r 0
        // 2 q 0 r 1
        while (num / 2 != 0) {
            stack.push(num % 2);
            num = num / 2;
        }
        stack.push(1);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
