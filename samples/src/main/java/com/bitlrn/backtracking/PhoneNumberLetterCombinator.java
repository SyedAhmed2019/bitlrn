package com.bitlrn.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumberLetterCombinator {
    private final Map<Integer, String> numberToLettersMap = Map.of(2, "ABC", 3, "DEF", 4, "GHI", 5, "JKL", 6, "MNO", 7, "PQRS", 8, "TUV", 9, "WXYZ");

    public static void main(String[] args) {
        PhoneNumberLetterCombinator pnlc = new PhoneNumberLetterCombinator();
        List<Integer> numbers = List.of(5, 6);
        pnlc.combine(numbers).forEach(System.out::println);
    }

    private void combineHelper(List<Integer> numbers, int index, int max, String currentCombination, List<String> combinations) {
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

    private List<String> combine(List<Integer> numbers) {
        List<String> combinations = new ArrayList<>();
        combineHelper(numbers, 0, numbers.size(), "", combinations);
        return combinations;
    }


}
