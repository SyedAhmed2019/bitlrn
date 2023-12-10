package com.bitlrn.hijri1445.scaler;

import java.util.Arrays;
import java.util.Scanner;

public class FirstLastPositionOfX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = scanner.nextInt();
        }
        Arrays.sort(input);
        int target = scanner.nextInt();
        int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < size; ++i) {
            if (input[i] == target) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else {
                    lastIndex = i;
                }
            }
        }
        if ((lastIndex == -1) && (firstIndex == -1)) {
            System.out.println(-1);
        } else if (lastIndex == -1) {
            System.out.print(firstIndex + " ");
            System.out.println(lastIndex);
        } else {
            System.out.print(firstIndex + " ");
            System.out.println(lastIndex);
        }
    }
}
