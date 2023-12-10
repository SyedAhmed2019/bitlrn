package com.bitlrn.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {

    private static final Map<Integer, String> numberToLettersMap = Map.of(2, "ABC", 3, "DEF", 4, "GHI", 5, "JKL", 6, "MNO", 7, "PQRS", 8, "TUV", 9, "WXYZ");

    private static void combineHelper(List<Integer> numbers, int index, int max, String currentCombination, List<String> combinations) {
        if (index == max) {
            combinations.add(currentCombination);
            return;
        }

        for (int j = 0; j < numberToLettersMap.get(numbers.get(index)).length(); ++j) {
            currentCombination += numberToLettersMap.get(numbers.get(index)).charAt(j);
            combineHelper(numbers, index + 1, max, currentCombination, combinations);
            currentCombination = currentCombination.substring(0, currentCombination.lastIndexOf(numberToLettersMap.get(numbers.get(index)).charAt(j)));

        }
    }

    public static List<String> letterCombinationsOfPhoneNumber(String digits) {
        List<Integer> numbers = new ArrayList<>();
        for (Character current : digits.toCharArray()) {
            numbers.add(Integer.parseInt("" + current));
        }
        List<String> combinations = new ArrayList<>();
        combineHelper(numbers, 0, numbers.size(), "", combinations);
        // WRITE YOUR BRILLIANT CODE HERE
        return combinations.stream().map(a -> a.toLowerCase()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();
        scanner.close();
        List<String> res = letterCombinationsOfPhoneNumber(digits);
        System.out.println(String.join(" ", res));
    }
}
