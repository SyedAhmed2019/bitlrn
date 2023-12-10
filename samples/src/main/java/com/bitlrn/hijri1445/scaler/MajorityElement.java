package com.bitlrn.hijri1445.scaler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Element that appears more than N/2 times in the N array
 * e.g
 * 1 ,2, 2 ,2
 * N = 4
 * n/2 = 2
 * e.g
 * 1 2 1 2 1 2 1 2 1 2 1 2 2
 * N = 13
 * N/2 = 6
 * ans: 2
 * sort = nlog n
 * and then find the last N/2 is same?
 */
public class MajorityElement {
    public static void main(String[] args) {
        // majorityElementOnOn();
        majorityElementMooresTheorem();
    }

    // 11111 11111
    // 1 2 3 4 5 6 7 8 9 0
    // 1 2 3 4 2 2 2 2 2 2
    private static void majorityElementMooresTheorem() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        int current = input[0];
        int currentCount = 1;
        int i = 1;
        while (i < size) {
            if (current != input[i]) {
                currentCount--;
                if (currentCount == 0) {
                    current = input[i];
                    currentCount = 1;
                }
            } else {
                currentCount++;
            }

            i++;
        }
        currentCount = 0;
        for (int j = 0; j < size; ++j) {
            if (input[j] == current) {
                currentCount++;
            }
        }
        if (currentCount > size / 2) {
            System.out.println(current);
        }

    }

    private static void majorityElementOnOn() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < size; ++i) {
            int current = scanner.nextInt();
            if (cache.containsKey(current)) {
                cache.computeIfPresent(current, (k, v) -> v = v + 1);
            } else {
                cache.put(current, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() > size / 2) {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("-1");
    }
}
