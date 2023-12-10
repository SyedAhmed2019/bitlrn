package com.bitlrn.dgio.queue;

public class PalindromeChecker {
    private CircularQueue<Character> queue;

    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker();
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("input string to be checked for palindrome");
        System.out.println(pc.checkPalindrome("madam"));
        System.out.println(pc.checkPalindrome("racecar"));
        System.out.println(pc.checkPalindrome("openai"));
        System.out.println(pc.checkPalindrome("A man a plan a canal Panama"));
        System.out.println(pc.checkPalindrome("Mada'm"));
    }

    public boolean checkPalindrome(String s) {
        queue = new CircularQueue<>(s.length());
        //racecar
        int low = 0;
        int high = s.length() - 1;
        // racecar
        // man'sn'am
        while (low < high) {
            if (!isCharacterAlphaNumeric(s.charAt(low))) {
                low++;
                continue;
            }
            if (!isCharacterAlphaNumeric(s.charAt(high))) {
                high--;
                continue;
            }
            queue.queue(s.charAt(low));

            if (Character.toLowerCase(queue.peek()) == Character.toLowerCase(s.charAt(high))) {
                queue.dequeue();
            }
            low++;
            high--;
        }
        return queue.isEmpty();
    }

    private boolean isCharacterAlphaNumeric(char c) {
        return (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || ('0' <= c && c <= '9'));
    }
}
