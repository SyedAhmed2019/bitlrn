package com.bitlrn.hijri1445.arrays;

import java.util.Scanner;

public class LinearSearchExample {
    private final Scanner scanner = new Scanner(System.in);
    private int[] array;

    public static void main(String[] args) {
        LinearSearchExample lse = new LinearSearchExample();

        System.out.println(" Enter the size of array to fill");
        int inputSize = lse.scanner.nextInt();
        lse.fillArray(inputSize);
        lse.search();

    }

    private void search() {
        System.out.println("Enter the element to search in array:");
        int find = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == find) {
                System.out.println(" Found element at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Didn't find " + find + " in array");
        }

    }

    private void fillArray(int inputSize) {
        array = new int[inputSize];
        for (int i = 0; i < inputSize; ++i) {
            System.out.println("Enter " + i + " element in array");
            array[i] = scanner.nextInt();
        }
    }
}
