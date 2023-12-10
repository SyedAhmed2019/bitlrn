package com.bitlrn.hijri1445.scaler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThreeSum {

    // 1, 2,3, 2,2,2,0,2,4  target = 6
    // 1 - 1
    // 2 - 5
    // 3 - 1
    // 0 = 1
    // 4 - 1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] input = new int[count];
        int[] result = new int[2];
        Map<Integer, Integer> cache1 = new HashMap<>(count);
        for (int i = 0; i < count; ++i) {
            input[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        for (int i = 0; i < count; ++i) {
            cache1.putIfAbsent(input[i], 0);
            cache1.computeIfPresent(input[i], (k, v) -> v + 1);
        }
        for (int i = 0; i < count; ++i) {
            for (int j = i + 1; j < count; ++j) {
                if (cache1.containsKey(target - input[i] - input[j])) {
                    if (cache1.get(target - input[i] - input[j]) != 0) {
                        System.out.println(target - input[i] - input[j] + "'" + input[i] + "'" + input[j]);
                        cache1.computeIfPresent(target - input[i] - input[j], (k, v) -> v = v - 1);
                    } else {
                        cache1.remove(target - input[i] - input[j]);
                    }
                }
            }
        }
    }
}
