package com.bitlrn.backtracking.memoization;

import java.util.List;
import java.util.Scanner;

/**
 * Given a string and a list of words, determine if the string can be
 * constructed from concatenating words from the list of words. A word can be used multiple times.
 * <p>
 * Input:
 * <p>
 * target = "algomonster"
 * words = ["algo", "monster"]
 * Output: true
 * <p>
 * Input:
 * <p>
 * target = "aab"
 * words = ["a", "c"]
 * Output: false
 */
public class WordFromWordsGenerator {
    public static void main(String[] args) {
        WordFromWordsGenerator wfwGen = new WordFromWordsGenerator();
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] words = inputLine.split(" ");
        List<String> inputList = List.of(words);
        System.out.println(inputList);
        String targetWord = scanner.next();
        System.out.println(wfwGen.generate(0, targetWord, inputList, ""));
        System.out.println("Memoization output" + wfwGen.generateMemoization(0, targetWord, inputList));
    }

    private boolean generate(int index, String targetWord, List<String> inputList, String combineWord) {
        if (index <= inputList.size()) {
            if (combineWord.equals(targetWord)) {
                return true;
            }
        } else {
            return false;
        }
        String word;
        int current = index;
        while (current < inputList.size()) {
            word = inputList.get(current);
            combineWord += word;
            current++;
            if (generate(index + 1, targetWord, inputList, combineWord)) {
                return true;
            }
            combineWord = combineWord.substring(0, inputList.lastIndexOf(word));
        }
        return false;
    }


    // abcde
    // a b c d e

    private boolean generateMemoization(int index, String targetWord, List<String> inputList) {
        if (index == targetWord.length()) {
            return true;
        }
        boolean ans = false;
        for (String word : inputList) {
            if (targetWord.substring(index).startsWith(word)) {
                ans = ans || generateMemoization(index + word.length(), targetWord, inputList);
            }
        }
        return ans;
    }
}
