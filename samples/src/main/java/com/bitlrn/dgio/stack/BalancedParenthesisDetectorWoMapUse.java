package com.bitlrn.dgio.stack;

public class BalancedParenthesisDetectorWoMapUse {
    public static void main(String[] args) {
        BalancedParenthesisDetectorWoMapUse bp = new BalancedParenthesisDetectorWoMapUse();

        // Test cases to verify the solution
        String test1 = "{[()]}";
        String test2 = "{[}]";
        String test3 = "(]";

        System.out.println("Test 1: " + bp.isValid(test1));
        System.out.println("Test 2: " + bp.isValid(test2));
        System.out.println("Test 3: " + bp.isValid(test3));
    }

    public boolean isValid(String s) {
        // Creating a stack to keep track of opening parentheses
        Stack<Character> stack = new Stack<>(s.length());

        // Iterating through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is an opening parenthesis, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty and we have a closing parenthesis, the string is not balanced
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top character from the stack
                char top = stack.pop();
                // If the character is a closing parenthesis, check whether
                // it corresponds to the most recent opening parenthesis
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening parentheses had a corresponding closing match
        return stack.isEmpty();
    }
}
