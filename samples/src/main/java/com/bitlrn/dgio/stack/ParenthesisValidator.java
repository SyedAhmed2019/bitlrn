package com.bitlrn.dgio.stack;

import java.util.HashMap;
import java.util.Map;

public class ParenthesisValidator {
    Stack<Character> stack;
    Map<Character, Character> mapper = new HashMap<>();

    public static void main(String[] args) {
        ParenthesisValidator pv = new ParenthesisValidator();
        System.out.println(pv.isValid("{]"));
        System.out.println(pv.isValid("{[]}"));
        System.out.println(pv.isValid("[{]}"));
    }

    // "{]"
    // "{[]}"
    // "[{]}"
    public boolean isValid(String s) {
        mapper = Map.of('}', '{', ')', '(', ']', '[');
        stack = new Stack<>(s.length());
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && mapper.get(c) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
