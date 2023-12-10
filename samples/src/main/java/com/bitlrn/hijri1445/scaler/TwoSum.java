package com.bitlrn.hijri1445.scaler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.abs;

public class TwoSum {

    // 3 2 4 5 1 8
    // target = 7
    // -3 2 -4 5 1 8
    // -7
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] input = new int[count];
        int[] result = new int[2];
        Map<Integer, Integer> cache = new HashMap<>(count);
        for (int i = 0; i < count; ++i) {
            input[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        for (int i = 0; i < count; ++i) {
            if (!cache.containsKey(abs(input[i]))) {
                cache.put(abs(target - input[i]), i);
            } else {
                result[0] = cache.get(abs(input[i]));
                result[1] = i;
                System.out.println(result[0] + "," + result[1]);
                break;
            }
        }
    }
}
