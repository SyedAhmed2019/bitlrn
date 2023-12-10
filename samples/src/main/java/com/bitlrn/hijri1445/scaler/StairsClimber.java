package com.bitlrn.hijri1445.scaler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StairsClimber {

    public static void main(String[] args) {
        StairsClimber sc = new StairsClimber();
        Scanner scanner = new Scanner(System.in);
        // stair steps - top stair
        //int top = scanner.nextInt();
        List<Integer> results = new ArrayList<>();
        //sc.climbStairsPaths(top,0, results);
        //System.out.println(results.size());
        // dp approch for 45
        //System.out.println(sc.climbStairsSumOfPathsDp(top, new int[top+1]));

        //System.out.println(sc.climbStairsSumOfPathTab(top));
        int[] dp = new int[]{1, 2, 4, 3, 6, 5, 2, 7, 1};
        //System.out.println(sc.costOfClimbStairsPath(dp.length, dp));
        System.out.println(sc.costOfClimbStairsPathDp(dp.length, dp, new int[dp.length + 1]));
        System.out.println("using tabulation");
        System.out.println(sc.costOfClimbStairsPathTabulation(dp.length, dp, new int[dp.length + 1]));

    }

    int climbStairsSumOfPathTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];

    }

    int climbStairsSumOfPathsDp(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] == 0) {
            dp[n] = climbStairsSumOfPathsDp(n - 1, dp) + climbStairsSumOfPathsDp(n - 2, dp) + climbStairsSumOfPathsDp(n - 3, dp);
        }
        return dp[n];
    }

    // takes quite a time for 45 input
    int climbStairsSumOfPaths(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int firstWay = climbStairsSumOfPaths(n - 1);
        int secondWay = climbStairsSumOfPaths(n - 2);
        int thirdWay = climbStairsSumOfPaths(n - 3);

        return firstWay + secondWay + thirdWay;

    }

    // 1 2 3 4 5
    // [5]          -- 15
    //      [4]      --  10
    //          [3]     --> 6
    //              [2]     --> 3
    //                  [1] --> 1


    //    [5]    -- 5+ 4
    //       [3]  --  3+1
    //          [1] -- 1

    void climbStairsPaths(int top, int currentStep, List<Integer> results) {
        if (currentStep == top) {
            System.out.println(results);
            return;
        }
        if (currentStep < top) {
            results.add(currentStep + 1);
            climbStairsPaths(top, currentStep + 1, results);
            results.remove(results.size() - 1);
            results.add(currentStep + 2);
            climbStairsPaths(top, currentStep + 2, results);
            results.remove(results.size() - 1);
            results.add(currentStep + 3);
            climbStairsPaths(top, currentStep + 3, results);
            results.remove(results.size() - 1);
        }

    }

    int costOfClimbStairsPath(int top, int[] weightsArray) {
        if (top == 1) {
            return weightsArray[0];
        }
        if (top == 2) {
            return weightsArray[0] + weightsArray[1];
        }
        int oneStep = costOfClimbStairsPath(top - 1, weightsArray);
        int twoStep = costOfClimbStairsPath(top - 2, weightsArray);
        return Math.min(oneStep, twoStep) + weightsArray[top - 1];
    }

    int costOfClimbStairsPathDp(int top, int[] weightsArray, int[] dp) {
        if (top == 1) {
            return weightsArray[0];
        }
        if (top == 2) {
            return weightsArray[0] + weightsArray[1];
        }
        if (dp[top] == 0) {
            int oneStep = costOfClimbStairsPathDp(top - 1, weightsArray, dp);
            int twoStep = costOfClimbStairsPathDp(top - 2, weightsArray, dp);
            return Math.min(oneStep, twoStep) + weightsArray[top - 1];
        } else {
            return dp[top];
        }
    }

    int costOfClimbStairsPathTabulation(int top, int[] weightsArray, int[] dp) {
        dp[0] = weightsArray[0];
        dp[1] = dp[0] + weightsArray[1];
        for (int i = 2; i <= top; ++i) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + weightsArray[i - 1];
        }
        return dp[top];
    }
}
