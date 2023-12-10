package com.bitlrn.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatchingParenthesesGenerator {

    // (()),()()
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many matching parenthesis to generate?");
        int count = scanner.nextInt();
        List<List<Character>> matching1 = new ArrayList<>();
        MatchingParenthesesGenerator mpg = new MatchingParenthesesGenerator();
        List<Character> inputChar = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            if (i % 2 == 0) {
                inputChar.add('(');
            } else {
                inputChar.add(')');
            }
        }
        mpg.matcher(0, inputChar, new ArrayList<Character>(), 0, 0, matching1);
        matching1.forEach(System.out::println);
        System.out.println("Optimal one");
        List<List<String>> matching2 = new ArrayList<>();
        mpg.matcherOptimal(0, count, new ArrayList<>(), 0, 0, matching2);
        for (List<String> current : matching2) {
            System.out.println(current);
        }


    }

    /**
     * Note: the logic was corrected based on solution recommendation.
     */
    private void matcher(int current, List<Character> input, List<Character> combination, int lc, int rc, List<List<Character>> matching) {
        if (combination.size() == input.size() * 2) {
            matching.add(new ArrayList<>(combination));
            return;
        }

        for (Character c : List.of('(', ')')) {
            if (c == '(' && lc >= 2) {
                continue;
            } else if (c == ')' && rc >= lc) {
                continue;
            }
            if (c == '(') {
                lc++;
            } else {
                rc++;
            }
            combination.add(c);
            matcher(current, input, combination, lc, rc, matching);
            if (c == '(') {
                lc--;
            } else {
                rc--;
            }
            combination.remove(combination.size() - 1);

        }

    }

    private void matcherOptimal(int current, int max, List<Character> path, int lc, int rc, List<List<String>> res) {
        if (path.size() == 2 * max) {
            res.add(path.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.toList()));
            return;
        }
        if (lc < max) {
            path.add('(');
            matcherOptimal(current, max, path, lc + 1, rc, res);
            path.remove(path.size() - 1);
        }
        if (rc < lc) {
            path.add(')');
            matcherOptimal(current, max, path, lc, rc + 1, res);
            path.remove(path.size() - 1);
        }
    }


    private boolean isValidFlow(List<Character> chars) {
        return chars.get(0) == '(';
    }
}
