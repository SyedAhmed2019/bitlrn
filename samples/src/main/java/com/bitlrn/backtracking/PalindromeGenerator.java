package com.bitlrn.backtracking;

import java.util.*;

public class PalindromeGenerator {
    private final Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        PalindromeGenerator pg = new PalindromeGenerator();

        //pg.palindromesNonOptimal(0,input,"");
        List<List<String>> partitions = pg.partition(input);
        partitions.forEach(System.out::println);
    }

    private List<List<String>> partition(String input) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(input, new ArrayList<String>(), 0, result);
        return result;
    }

    private void partitionHelper(String input, ArrayList<String> partition, int current, List<List<String>> result) {
        if (current == input.length()) {
            result.add(new ArrayList<>(partition));
        }
        for (int i = current; i < input.length(); i++) {
            if (isPalindrome2(input.substring(current, i + 1))) {
                partition.add(input.substring(current, i + 1));
                partitionHelper(input, partition, i + 1, result);
                partition.remove(partition.size() - 1);
            }
        }

    }
    // abcba

    private void palindromesNonOptimal(int current, String input, String currentPalindrome) {
        if (current == input.length()) {
            if (isPalindrome(currentPalindrome)) {
                result.add(currentPalindrome);
            }
            return;
        }
        if (isPalindrome(currentPalindrome)) {
            result.add(currentPalindrome);
        }
        // prune condition
        currentPalindrome += input.charAt(current);
        palindromesNonOptimal(current + 1, input, currentPalindrome);
        currentPalindrome = currentPalindrome.substring(0, currentPalindrome.lastIndexOf(input.charAt(current)));
        palindromesNonOptimal(current + 1, input, currentPalindrome);
    }


    public boolean isPalindrome2(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String currentPalindrome) {
        if (currentPalindrome.length() == 1) {
            return true;
        }
        int leftSum = 0;
        int rightSum = 0;
        char[] inputCharacters = currentPalindrome.toCharArray();
        for (int i = 0, j = currentPalindrome.length() - 1; i < j; ++i, j--) {
            leftSum += inputCharacters[i];
            rightSum += inputCharacters[j];
        }
        return leftSum == rightSum;
    }

    //abbc
    private boolean isPrefixPalindrome(String currentPalindrome, String input) {
        if (!currentPalindrome.isEmpty()) {
            if (currentPalindrome.length() == 1) {
                return true;
            }
            return currentPalindrome.length() < input.length() / 2 || currentPalindrome.charAt(0) == input.charAt(input.length() - 1);
        }
        return false;
    }
}
