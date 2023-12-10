package com.bitlrn.hijri1445.timecomplexity;

import java.util.Scanner;

/**
 * this eample shows sample code of the
 * time complexity of logN.
 * e.g. when input is given as 1000000
 * you can see that it gets completed in ~20 iterations.
 * <p>
 * log 1000000 (considering base 2)
 * is approximately 20 as 1000000 is approximately log 2^20
 */
public class BigO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        System.out.println("Sample showing logN complexity");
        logN(1000000);
        System.out.println("===================================");
        System.out.println("Sample showing O(N) complexity");
        bigO_N(100);
        big_O_n(10);
        System.out.println("Sample showing O(N^2) complexity");
        bigO_N_2(100);
        System.out.println("===================================");
        System.out.println("Sample showing O(NLogN) complexity");
        NLogN(100);
        System.out.println("===================================");
        System.out.println("Sample showing O(2^N) complexity");
        big_O_2_exp_N(5, 1);
        System.out.println("===================================");

    }

    private static void bigO_N_2(int n) {
        int iteration = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.println("Iteration " + (iteration++));
            }
        }
    }

    private static void bigO_N(int n) {
        for (int i = 1; i < 100; ++i) {
            System.out.println("iteration " + i);
        }
    }

    private static void logN(int n) {
        int i = 0;
        while (n > 1) {
            n = n / 2;
            System.out.println("Iteration " + (i++) + " value of n " + n);
        }
    }

    private static void NLogN(int n) {
        int iteration = 0;
        int m = n;
        for (int i = 1; i <= n; ++i) {
            while (m > 1) {
                System.out.println("iteration " + (++iteration));
                m /= 2;
            }
            if (m == 1) {
                System.out.println("iteration " + (++iteration));
            }
        }
    }

    private static int big_O_2_exp_N(int n, int iteration) {
        //printing fibonacci series
        if (n == 1 || n == 0) {
            return 1;
        }
        int sum = big_O_2_exp_N(n - 1, iteration + 1) + big_O_2_exp_N(n - 2, iteration + 1);
        System.out.println("iteration" + (iteration) + " current fib number " + sum);
        return sum;
    }

    private static void big_O_n(int N) {
        int[][] ar = new int[N][N];
        int iteration = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                System.out.println("iteration =" + (++iteration));
            }
        }
    }
}
