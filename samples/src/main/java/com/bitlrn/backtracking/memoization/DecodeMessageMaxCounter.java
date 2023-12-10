package com.bitlrn.backtracking.memoization;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * We have a message consisting of digits 0-9 to decode. Letters are encoded to digits by their positions in the alphabet
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Y -> 25
 * Z -> 26
 * Given a non-empty string of digits, how many ways are there to decode it?
 * <p>
 * Input: "18"
 * <p>
 * Output: 2
 * <p>
 * Explanation: "18" can be decoded as "AH" or "R"
 * <p>
 * Input: "123"
 * <p>
 * Output: 3
 * <p>
 * Explanation: "123" can be decoded as "ABC", "LC", "AW"
 */
public class DecodeMessageMaxCounter {
    private final Map<Integer, Character> dict = Map.of(1, 'A', 2, 'B', 3, 'C');
    private final Map<String, Integer> cacheResult = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.next();
        DecodeMessageMaxCounter dmmc = new DecodeMessageMaxCounter();
        System.out.println(dmmc.decodeCount(0, digits));

    }

    //123


    private int decodeCount(int index, String digits) {
        if (index == digits.length()) {
            return 1;
        }
        //decode one digits
        int count = 0;
        if (digits.charAt(0) == '0') {
            return 0;
        }
        count += decodeCount(index + 1, digits);
        if ((index + 2) <= digits.length() && Integer.parseInt(digits.substring(index, index + 2)) <= 26) {
            count += decodeCount(index + 2, digits);
        }
        return count;
    }
}
