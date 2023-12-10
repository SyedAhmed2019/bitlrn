package com.bitlrn.binarysearch;

import java.util.List;

public class BinarySearchSolution {
    public static int binarySearchMain(List<Integer> arr, int low, int high, int target) {
        while (low < high) {
            int midpoint = low + (high - low) / 2;
            if (arr.get(midpoint) == target) {
                return midpoint;
            } else if (target < arr.get(midpoint)) {
                high = midpoint - 1;
            } else {
                low = midpoint + 1;
            }
        }
        return -1;
    }

    public static int binarySearch(List<Integer> arr, int target) {
        return binarySearchMain(arr, 0, arr.size(), target);
    }

    public static void main(String[] args) {
        List<Integer> source = List.of(10, 9, 8, 7, 5, 4, 3, 2, 1);
        System.out.println(binarySearch(source, 5));
    }
}
