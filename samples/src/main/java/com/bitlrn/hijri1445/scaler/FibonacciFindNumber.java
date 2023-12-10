package com.bitlrn.hijri1445.scaler;

/**
 * Find fibonacci Nth number
 * What is fibonacci?
 * 0 1 1 2 3 5
 * 0 1
 * 1
 * 2
 * 3
 * 0 1 1 2 3 5 8 13 21 34
 */
public class FibonacciFindNumber {


    public static void main(String[] args) {
        FibonacciFindNumber ffn = new FibonacciFindNumber();
        int prev = 0;
        int next = 1;

        //System.out.println(ffn.findNNumber(0,1,1,45));
        //System.out.println(ffn.fibPlain(45));
        int fibNumInSeries = 45;
        int[] cache = new int[fibNumInSeries + 1];
        cache[0] = 0;
        cache[1] = 1;
        System.out.println(ffn.fibWithDp(fibNumInSeries, cache));
        System.out.println("with tabulation");
        System.out.println(ffn.fibWithTabulation(45));
    }

    private int findNNumber(int current, int next, int index, int target) {
        if (target == index) {
            return next;
        } else if (target < index) {
            return current;
        }
        return findNNumber(next, current + next, index + 1, target);
    }

    private int fibPlain(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibPlain(n - 2) + fibPlain(n - 1);
    }

    private int fibWithDp(int n, int[] cache) {
        if (n == 0 || n == 1) {
            return n;
        }
        int preprev;
        int prev;

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fibWithDp(n - 2, cache) + fibWithDp(n - 1, cache);
        return cache[n];

    }

    private int fibWithTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
}
