package com.bitlrn.hijri1445.scaler;


import java.util.ArrayList;
import java.util.List;

/**
 * Given N numbers print their permutations.
 */
public class Permutations {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        boolean[] selected = new boolean[input.length];
        List<Integer> result = new ArrayList<>();

        Permutations perms = new Permutations();
        perms.permutate(input, 0, selected, result);

    }

    // 1 2 3
    void permutate(int[] input, int pos, boolean[] selected, List<Integer> result) {
        if (result.size() == input.length) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < input.length; ++i) {
            if (!selected[i]) {
                selected[i] = true;
                result.add(input[i]);
                permutate(input, pos + 1, selected, result);
                selected[pos] = false;
                result.remove(result.size() - 1);
            }
        }

    }
}
