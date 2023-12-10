package com.bitlrn.dgio.stack;

/**
 * Given a string s, where '*' represents a star. We can remove a star along with its closest non-star
 * character to its left in a single operation. The task is to perform as many such operations as possible
 * until all stars have been removed and return the resultant string.
 */
public class AdjCharStarRemover {

    public static String removeStars(String s) {
        Stack<Character> input = new Stack<>(s.length());
        for (Character current : s.toCharArray()) {
            if (!input.isEmpty() && current == '*') {
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
        //output abdf
        System.out.println(removeStars("abc*de*f"));
        //output d
        System.out.println(removeStars("a*b*c*d"));
        // output ""
        System.out.println(removeStars("abcd"));

    }
}
