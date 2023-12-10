package com.bitlrn.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SumReverseSort {
    public static void main(String[] args) {
        int[] input = new int[]{-35, 31, 22, 11, 81, 51, 42};
        int[] reverse = new int[]{8, 4, 4, 2, 9, 6, 6};// {9,8,6,6,4,4,2}


        SumReverseSort srs = new SumReverseSort();
        System.out.println(srs.calculate(input));


    }

    private int sumDigits(int number) {
        int sum = 0;
        while (Math.abs(number / 10) > 0) {
            sum += Math.abs(number % 10);
            number = Math.abs(number / 10);
        }
        sum += Math.abs(number % 10);
        return sum;
    }

    private int calculate(int[] input) {
        Integer[] result = new Integer[input.length];
        int high = input.length - 1;
        for (int i = 0; i < input.length; ++i) {
            result[high--] = sumDigits(input[i]);
        }
        System.out.println(List.of(result));
        Arrays.sort(result, Comparator.reverseOrder());
        int finalResult = -1;
        for (int i = 0; i < result.length; ++i) {
            if (sumDigits(input[i]) == result[1]) {
                finalResult = input[i];
                break;
            }
        }
        return finalResult;
    }
}
