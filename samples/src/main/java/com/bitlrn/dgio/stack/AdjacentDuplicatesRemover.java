package com.bitlrn.dgio.stack;

/**
 * You are given a string s and we want to make it a valid string. A string is considered
 * valid if it does not have any two adjacent duplicate characters. The goal is to remove the minimum number of
 * characters from s such that it becomes valid. The removal of characters should be done
 * in a way that no further removals are required.
 */
public class AdjacentDuplicatesRemover {

    public static String removeDuplicates(String s) {
        Stack<Character> input = new Stack<>(s.length());
        for (Character current : s.toCharArray()) {
            if (!input.isEmpty() && input.peek() == current) {
                input.pop();
            } else {
                input.push(current);
            }
        }
        StringBuilder result = new StringBuilder();
        // while stack has items
        while (!input.isEmpty()) {
            result.append(input.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        //output ca
        System.out.println(removeDuplicates("abbaca"));
        //output ay
        System.out.println(removeDuplicates("azxxzy"));
        // output ""
        System.out.println(removeDuplicates("abba"));

    }
}
