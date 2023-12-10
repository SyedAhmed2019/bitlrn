package com.bitlrn.hijri1445.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Factorial {

    private static final Scanner scanner = new Scanner(System.in);
    private final Map<Long, Long> history = new HashMap<>();

    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println("Enter the number to find factorial of: ");
        int input = scanner.nextInt();
        long initial = System.currentTimeMillis();
        System.out.println("Factorial of " + input + " is " + fact.findFactorial(input));
        System.out.println("Time taken is " + (System.currentTimeMillis() - initial));
        initial = System.currentTimeMillis();
        System.out.println("Factorial using DP of " + input + " is " + fact.findFactorialDp(input));
        System.out.println("Time taken is " + (System.currentTimeMillis() - initial));
    }

    private long findFactorial(long input) {
        if (input == 0 || input == 1) {
            return 1;
        }

        return input * findFactorial(input - 1);
    }

    private long findFactorialDp(long input) {
        if (input == 0 || input == 1) {
            return 1;
        }
        if (history.get(input) != null) {
            return history.get(input);
        }
        long result = input * findFactorial(input - 1);
        history.put(input, result);
        return result;
    }

}
