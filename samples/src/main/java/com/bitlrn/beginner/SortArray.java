package com.bitlrn.beginner;

import com.bitlrn.util.Instrumentation;

/**
 * Give an array list of integers sort them in ascending order
 */
public class SortArray {
    private final Instrumentation instrumentation;

    public SortArray() {
        instrumentation = new Instrumentation();
    }

    /**
     * [9,8,7.6.5]
     * 0 compares with 4
     * 1 compares with 3
     * 2 compares with 2
     * 3 compares with 1
     */
    public void bruteForce(int[] input) {
        for (int i = 0; i < input.length; ++i) {
            for (int j = i + 1; j < input.length; ++j) {
                if (input[i] > input[j]) {
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
                instrumentation.increment();
            }
        }
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }
}
