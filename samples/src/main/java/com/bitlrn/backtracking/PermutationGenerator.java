package com.bitlrn.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationGenerator {
    public static void main(String[] args) {
        PermutationGenerator pg = new PermutationGenerator();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[input.length()];
        pg.permutation(input, used, "", result);
        result.forEach(System.out::println);
    }

    private void permutation(String input, boolean[] used, String currentCombination, List<String> result) {
        if (currentCombination.length() == input.length()) {
            result.add(currentCombination);
            return;
        }

        for (int i = 0; i < input.length(); ++i) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            currentCombination += input.charAt(i);
            permutation(input, used, currentCombination, result);
            currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
            used[i] = false;
        }
    }


}
