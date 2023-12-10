package com.bitlrn.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LettersCombinator {

    public static void main(String[] args) {
        LettersCombinator lc = new LettersCombinator();
        Scanner scanner = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        input.add("a");
        input.add("b");
        List<String> combinations = new ArrayList<>();
        lc.combine(0, 4, "", input, combinations);
        for (String item : combinations) {
            System.out.println(item);
        }

    }

    private void combine(int current, int max, String currentCombination, List<String> input, List<String> combinations) {
        if (current < 0 || current >= max) {
            combinations.add(currentCombination);
            return;
        }
        for (String in : input) {
            currentCombination += in;
            combine(current + 1, max, currentCombination, input, combinations);
            currentCombination = currentCombination.substring(0, currentCombination.lastIndexOf(in));
        }
    }
}
