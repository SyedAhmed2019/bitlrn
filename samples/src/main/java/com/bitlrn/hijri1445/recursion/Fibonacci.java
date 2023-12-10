package com.bitlrn.hijri1445.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

    private static final Scanner scanner = new Scanner(System.in);
    Map<Long, Long> history = new HashMap<>();

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("Please enter the number to generate fib series");

        fib.generateUsingRecursion(scanner.nextInt());
    }

    // I N Sum
    // 0 1 1
    // 1 1 2
    // 1 2 3
    // 2 3 5
    private void generate(int input) {

        if (input <= 0) {
            System.out.println("Invalid");
            return;
        } else if (input == 1) {
            System.out.print(input - 1);
            return;
        }
        int initial = 0;
        int next = 1;
        System.out.println(initial);
        System.out.println(next);
        for (int i = 2; i < input; ++i) {
            int sum = initial + next;
            System.out.println(sum);
            initial = next;
            next = sum;
        }
    }

    // 0 - 1
    // 0 1  - 2

    private void generateUsingRecursion(int input) {
        // let us initially print the the two numbers
        history.put(0L, 0L);
        history.put(1L, 1L);

        for (long i = 0; i < input; ++i) {
            long millis = System.currentTimeMillis();
            long value = recurseEff(i);
            System.out.println("fibonacci at " + i + " is " + value);
            //history.put(i,value);
            System.out.println("Time taken:" + (System.currentTimeMillis() - millis));
        }

    }


    private long recurse(long input) {
        if (input <= 1) {
            return input;
        }
        return recurse(input - 1) + recurse(input - 2);
    }


    private long recurseEff(long input) {
        if (input <= 1) {
            return input;
        }
        long leftSum, rightSum;
        if (!history.containsKey(input - 1)) {
            leftSum = recurse(input - 1);
            history.put(input - 1, leftSum);
        } else {
            leftSum = history.get(input - 1);
        }

        if (!history.containsKey(input - 2)) {
            rightSum = recurse(input - 2);
            history.put(input - 2, rightSum);
        } else {
            rightSum = history.get(input - 2);
        }
        history.put(input, leftSum + rightSum);
        return leftSum + rightSum;
    }
}
