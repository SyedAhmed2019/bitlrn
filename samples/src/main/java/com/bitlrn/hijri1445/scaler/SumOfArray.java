package com.bitlrn.hijri1445.scaler;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array and target print the sequence of indices that
 * adds up to the target
 */
public class SumOfArray {

    public static void main(String[] args) {
        int[] input = {2, 4, 6, 10, 12, 18, 23};
        SumOfArray sumOfArray = new SumOfArray();
        int target = 12;
        sumOfArray.isPresent(input, target, 0, new ArrayList<>());
    }


    private void isPresent(int[] input, int target, int index, List<Integer> result) {
        if (index == input.length) {
            return;
        }
        if (target == 0) {
            System.out.println(result);
        }
        result.add(input[index]);
        isPresent(input, target - input[index], index + 1, result);
        result.remove(result.size() - 1);

        isPresent(input, target, index + 1, result);

    }

}
