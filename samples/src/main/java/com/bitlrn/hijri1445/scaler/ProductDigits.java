package com.bitlrn.hijri1445.scaler;

import java.util.Scanner;

/**
 * Given a number (e.g 100) find smallest number (455?)  so that the product of its digits ( 4*5*5 = 100)
 * i the number.
 */
public class ProductDigits {
    public static void main(String[] args) {
        ProductDigits pd = new ProductDigits();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int input = scanner.nextInt();
        if (input == 0) {
            System.out.println(0);
            return;
        }
        //int  [] result = pd.findPrimeFactors(input);
        String result = pd.findFactors(input);
        if (!result.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println(" cannot find product of digits");
        }

    }

    private int[] findPrimeFactors(int input) {
        int[] result = new int[10];
        for (int i = 9; i > 1; i--) {
            while (input % i == 0) {
                result[i] += 1;
                input = input / i;
            }
        }
        return result;
    }

    private String findFactors(int input) {
        //StringBuilder result = new StringBuilder();
        String result = "";
        for (int i = 9; i > 1; i--) {
            while (input % i == 0) {
                input = input / i;
                result = i + result;
            }
        }
        return result;
    }
}
