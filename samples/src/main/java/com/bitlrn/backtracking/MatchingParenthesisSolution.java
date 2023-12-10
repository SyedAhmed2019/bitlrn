package com.bitlrn.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class MatchingParenthesisSolution {
    private static void dfs(int startIndex, List<Character> path, int openCount, int closeCount, List<String> res, int n) {
        if (path.size() == 2 * n) {
            res.add(path.stream()
                    .map(e -> e.toString())
                    .collect(Collectors.joining()));
            return;
        }
        if (openCount < n) {
            path.add('(');
            dfs(startIndex, path, openCount + 1, closeCount, res, n);
            path.remove(path.size() - 1);
        }
        if (closeCount < openCount) {
            path.add(')');
            dfs(startIndex, path, openCount, closeCount + 1, res, n);
            path.remove(path.size() - 1);
        }
    }

    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, 0, res, n);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        List<String> res = generateParentheses(n);
        Collections.sort(res);
        for (String line : res) {
            System.out.println(line);
        }
    }
}