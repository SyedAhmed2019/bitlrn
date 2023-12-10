package com.bitlrn.hijri1445.scaler;

import java.util.List;

public class TestSolutionBinarySearch {
    public static void main(String[] args) {
        List<Integer> userInput = List.of(4, 5, 6, 7, 0, 1, 2, 3);
        TestSolutionBinarySearch bs = new TestSolutionBinarySearch();
        System.out.println(bs.search(userInput, 4));
    }

    int findMin(Integer[] input) {
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (input[mid] < input[right]) {
                right = mid;
            } else if (input[mid] > input[right]) {
                left = mid + 1;
            }
        }
        return left;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        Integer[] input = A.toArray(new Integer[0]);
        int minIndex = findMin(input);
        System.out.println(input[minIndex]);
        int left = 0;
        int right = input.length - 1;
        int target = B;
        if (target > input[minIndex] && target > input[right]) {
            right = minIndex - 1;
        } else if (target > input[minIndex] && target < input[right]) {
            left = minIndex + 1;
        } else {
            return minIndex;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (input[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
