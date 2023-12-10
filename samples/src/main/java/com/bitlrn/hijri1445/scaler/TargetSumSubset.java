package com.bitlrn.hijri1445.scaler;

import java.util.ArrayList;
import java.util.List;

public class TargetSumSubset {

    public static void main(String[] args) {
        int[] input = new int[]{10, 20, 30, 40, 50, 70};
        int target = 70;
        List<Integer> result = new ArrayList<>();
        TargetSumSubset tss = new TargetSumSubset();
        tss.findSubsets(input, 0, 70, result);
    }

    private void findSubsets(int[] input, int i, int target, List<Integer> result) {
        if (input.length == i) {
            if (target == 0) {
                System.out.println(result);
            }
            return;
        }
        //accept
        result.add(input[i]);
        findSubsets(input, i + 1, target - input[i], result);
        result.remove(result.size() - 1);

        //reject
        findSubsets(input, i + 1, target, result);
    }
}
