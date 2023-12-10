package com.bitlrn.beginner;

/**
 * Given two non-negative integers low and high.
 * Return the count of numbers between low and high (inclusive)
 * that are odd or even based on type requested.
 * <p>
 * Input: low = 3, high = 7 , type= ODD
 * Output: 3
 * [3,4,5,6,7]  result is [3,5,7]
 */
public class OddEvenCounter {
    public static int count(int low, int high, Type type) {
        int rangeSize = high - low + 1;
        if (type == Type.ODD) {
            if (low % 2 != 0 && high % 2 != 0) {
                return rangeSize / 2 + 1;
            } else {
                return rangeSize / 2;
            }
        } else {
            if (low % 2 == 0 && high % 2 == 0) {
                return rangeSize / 2 + 1;
            } else {
                return rangeSize / 2;
            }
        }
    }

    enum Type {
        ODD,
        EVEN
    }
}

