package com.bitlrn.hijri1445.scaler;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumSort {

    // 1 2 3 2 2 2 0 4 2
    // first+second+third =
    // 1+2+3 = 6
    // 2+3 = 6-1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] input = new int[count];
        for (int i = 0; i < count; ++i) {
            input[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        // nlogn
        Arrays.sort(input);

        for (int i = 0; i < count; ++i) {
            if (i == 0 || input[i - 1] != input[i]) {
                int current = target - input[i];
                int j = i + 1;
                int k = count - 1;
                while (j < k) {
                    if (input[j] + input[k] == current) {
                        System.out.println(input[i] + "," + input[j] + "," + input[k]);
                        while (input[j] == input[j + 1]) j++;
                        while (input[k] == input[k - 1]) k--;
                        j++;
                        k--;
                    } else if (input[j] + input[k] < current) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
    }
}
