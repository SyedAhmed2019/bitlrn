package com.bitlrn.hijri1445.scaler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class FourSumSort {

    public static void main(String[] args) {
        FourSumSort fSumSort = new FourSumSort();
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> input = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            input.add(scanner.nextInt());
        }
        int target = scanner.nextInt();
        ArrayList<ArrayList<Integer>> result = fSumSort.fourSum(input, target);
        for (ArrayList<Integer> current : result) {
            System.out.println(current);
        }
    }
    // 1 0 -1 0 -2 2
    // sort
    // -2 -1 0 0 1 2

    private ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Integer[] input = A.toArray(new Integer[0]);
        for (int i = 0; i < input.length; ++i) {
            if (i == 0 || !Objects.equals(input[i - 1], input[i])) {
                int current = B - input[i];
                int j = i + 1;
                int k = i + 2;
                int l = input.length - 1;
                if (j == input.length) {
                    break;
                }
                current = current - input[j];
                while (k <= l) {
                    ArrayList<Integer> currentResult = new ArrayList<>();
                    if (current == input[k] + input[l]) {
                        currentResult.add(input[i]);
                        currentResult.add(input[j]);
                        currentResult.add(input[k]);
                        currentResult.add(input[l]);
                        result.add(currentResult);
                        k++;
                        l--;
                    } else if (input[k] + input[l] < current) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
