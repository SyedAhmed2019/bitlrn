package com.bitlrn.hijri1445.hr;

import java.util.Scanner;

/**
 * Given an array of numbers find the rations of positive, negative and  zeros in them
 */
public class Ratios {
    public static void main(String[] args) {
        Ratios ratios = new Ratios();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = scanner.nextInt();
        }
        ratios.proportions(input);
    }

    private void proportions(int[] input) {
        double positives = 0;
        double negatives = 0;
        double zeroes = 0;
        for (int i = 0; i < input.length; ++i) {
            if (input[i] > 0) {
                positives++;
            } else if (input[i] < 0) {
                negatives++;
            } else {
                zeroes++;
            }
        }
        System.out.printf("%.6f \n %.6f \n %.6f", positives / input.length, negatives / input.length, zeroes / input.length);
    }
}
