package com.bitlrn.beginner;

public class PalindromeCount {
    public static void main(String[] args) {
        String s = "ababa";
        String s2 = "abb";
        String s3 = "baabb";
        int steps = palindromeCount(s);
        System.out.println("number of steps for " + s + " is " + steps);
        steps = palindromeCount(s2);
        System.out.println("number of steps for " + s2 + " is " + steps);
        steps = palindromeCount(s3);
        System.out.println("number of steps for " + s3 + " is " + steps);

    }

    private static int palindromeCount(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        StringBuilder s2 = new StringBuilder(s);
        String newString = s2.reverse().toString();
        if (newString.equals(s)) {
            return 1;
        }

        return 2;

    }
}
