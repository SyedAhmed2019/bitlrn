package com.bitlrn.hijri1445.scaler;

import java.util.Arrays;
import java.util.Scanner;

public class FirstLastPositionBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; ++i) {
            input[i] = scanner.nextInt();
        }
        Arrays.sort(input);
        int target = scanner.nextInt();
        int left = 0;
        int right = input.length - 1;

        int firstIndex = -1;
        int lastIndex = -1;
        // 1 2 2 2 3 4
        while (left < right) {
            int mid = (right + left) / 2;
            if (input[mid] == target) {
                if (firstIndex == -1) {
                    firstIndex = mid;
                } else if (mid < firstIndex) {
                    firstIndex = mid;
                } else {
                    break;
                }
                right = mid;
            } else if (input[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left = firstIndex;
        right = input.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (input[mid] == target) {
                if (lastIndex == -1) {
                    lastIndex = mid;
                } else if (mid > lastIndex) {
                    lastIndex = mid;
                } else {
                    break;
                }
                left = mid;
            } else if (input[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(firstIndex + " " + lastIndex);
    }
}
