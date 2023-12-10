package com.bitlrn.dgio.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * The "Balanced Parentheses" problem requires you to determine
 * if a given string of parentheses is balanced. A string of parentheses
 * is considered balanced if every opening parenthesis has a corresponding
 * closing parenthesis in the correct order.
 */
public class BalancedParenthesisDetector {
    public static void main(String[] args) {
        BalancedParenthesisDetector bpd = new BalancedParenthesisDetector();
        System.out.println(bpd.isValid("{[()]}"));
        System.out.println(bpd.isValid("{[}]"));
        System.out.println(bpd.isValid("(]"));
        System.out.println(bpd.isValid("}{{}"));
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('}', '{');
        mapping.put(')', '(');
        mapping.put(']', '[');
        char[] parens = s.toCharArray();
        Stack<Character> stack = new Stack<>(parens.length);
        for (int i = 0; i < parens.length; ++i) {
            try {
                if (parens[i] == '{' || parens[i] == '['
                        || parens[i] == '(') {
                    stack.push(parens[i]);
                } else if (parens[i] == '}' || parens[i] == ']' || parens[i] == ')') {
                    char current = stack.pop();
                    if (current != mapping.get(parens[i])) {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        // ToDo: Write Your Code Here.
        return stack.isEmpty();
    }
}
