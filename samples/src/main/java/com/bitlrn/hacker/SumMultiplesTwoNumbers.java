package com.bitlrn.hacker;

import java.util.Scanner;

public class SumMultiplesTwoNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number:");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter second number:");
        int secondNumber = scanner.nextInt();
        System.out.println("Enter the series max range[i.e. 1..max]:");
        int rangeMax = scanner.nextInt();
        int i = 1;
        int sumOfMultiples = 0;
        while (i <= rangeMax) {
            if (i % firstNumber == 0 && i % secondNumber == 0) {
                sumOfMultiples += i;
            }
        }
        System.out.println("The sum of multiples of " + firstNumber + " and " + secondNumber
        );
    }
}
