package com.bitlrn.backtracking.memoization;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given coins of different denominations and an amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * 11 = 5 + 5 + 1, 3 total coins
 * <p>
 * Example 2:
 * Input: coins = [3], amount = 1
 * <p>
 * Output: -1
 */
public class MinimumCoinsCombinator {
    private final Map<Integer, Integer> coinsCountTracker = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Integer[] coins = new Integer[input.length()];
        for (int i = 0; i < input.length(); ++i) {
            coins[i] = Integer.parseInt("" + input.charAt(i));
            System.out.print(coins[i]);
        }
        // nlogn
        Arrays.sort(coins);
        // input target
        int target = scanner.nextInt();
        MinimumCoinsCombinator mcc = new MinimumCoinsCombinator();

        System.out.println(mcc.minCoinsChange(coins, target, coins.length - 1));
        mcc.coinsCountTracker.forEach((k, v) -> System.out.println(k + "->" + v));


    }

    //1 2
    // 12 - 2 - 6;
    // 13


    private int minCoinsChange(Integer[] coins, int balance, int high) {
        int sum = 0;
        if (high < 0) {
            return -1;
        }
        if (balance >= coins[high]) {
            sum += balance / coins[high];
            coinsCountTracker.put(coins[high], balance / coins[high]);
            balance -= coins[high] * coinsCountTracker.get(coins[high]);
        }
        if (balance > 0) {
            return minCoinsChange(coins, balance, --high);
        }
        return sum;
    }
}
