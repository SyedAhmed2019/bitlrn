package com.bitlrn.backtracking.memoization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

// 1 3 5
// 14
// 4 coins
class Solution {
    private static final Map<Integer, String> callStack = new HashMap<>();
    private static final int stackIndex = 0;
    private static final File myfile = new File("/Users/sahmed/basheeruddin/tempout.txt");

    public static int minCoins(List<Integer> coins, int amount, int sum) {
        if (sum == amount) {
            return 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            //callStack.put(++stackIndex,"minCoins called with coin "+ coin + " with sum" + (sum+coin));
            int result = minCoins(coins, amount, sum + coin);
            if (result == Integer.MAX_VALUE) {
                //System.out.println("----print call stack when it reached stack index: "+ stackIndex + " ----");
                //callStack.values().forEach(System.out::println);
                continue;
            }
            ans = Math.min(ans, result + 1);

        }
        return ans;
    }

    public static int minCoinsMemoization(List<Integer> coins, int amount, int[] memo, int sum, List<Integer> coinTracker) throws IOException {
        if (sum == amount) {
            System.out.println(coinTracker);

            return 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;
        }
        if (memo[sum] != -1) {
            return memo[sum];
        }

        int ans = Integer.MAX_VALUE;
        for (int coin : coins) {
            coinTracker.add(coin);
            // callStack.put(++stackIndex,"minCoins called with coin "+ coin + " with sum" + (sum+coin));
            int result = minCoinsMemoization(coins, amount, memo, sum + coin, coinTracker);
            if (result == Integer.MAX_VALUE) {

            /*fos.write(("----print call stack when it reached stack index: "+ stackIndex + " ----").getBytes(StandardCharsets.UTF_8));
            callStack.values().forEach(v-> {
                try {
                    fos.write(v.getBytes(StandardCharsets.UTF_8));
                    fos.write("\n".getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            callStack.clear();*/
                continue;
            }
            //System.out.println(" current ans is "+ ans + " result of subree+1 =" +(result+1));
            ans = Math.min(ans, result + 1);

        }
        return memo[sum] = ans;
    }

    public static int coinChange(List<Integer> coins, int amount, FileOutputStream fos) throws IOException {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        coins.sort(Collections.reverseOrder());
        return minCoinsMemoization(coins, amount, memo, 0, new ArrayList<>());
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream(myfile)) {
            Scanner scanner = new Scanner(System.in);
            List<Integer> coins = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
            int amount = Integer.parseInt(scanner.nextLine());
            scanner.close();
            int res = coinChange(coins, amount, fos);
            System.out.println(res);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
