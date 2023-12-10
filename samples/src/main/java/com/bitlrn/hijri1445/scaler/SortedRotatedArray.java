package com.bitlrn.hijri1445.scaler;

/**
 * problem 1:  Given a sorted and rotated array find the minimum element
 */
public class SortedRotatedArray {


    public static void main(String[] args) {
        SortedRotatedArray sar = new SortedRotatedArray();

        //testFindMin(sar);

        int[] input4 = new int[]{9, 11, 14, 15, 22, 23, 1, 2, 3};
        System.out.println(sar.search(input4, 3));

        int[] input5 = new int[]{9, 11, 14, 15, 22, 23, 1, 2, 3};
        System.out.println(sar.search(input5, 11));

        int[] input6 = new int[]{9, 11, 14, 15, 22, 23, 1, 2, 3};
        System.out.println(sar.search(input6, 22));

    }

    private static void testFindMin(SortedRotatedArray sar) {
        int[] input = new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(input[sar.findMin(input)]);

        int[] input2 = new int[]{1, 3, 5, 5, 6, 7, 8, 9, 20, 21};
        System.out.println(input2[sar.findMin(input2)]);

        int[] input3 = new int[]{14, 15, 20, 22, 3, 5, 7, 9};
        System.out.println(input3[sar.findMin(input3)]);
    }

    //4,5,6,7,8,9,1,2,3
    //input[4]
    //left = 5;
    // right = 6
    int search(int[] input, int target) {
        int minIndex = findMin(input);
        int left = 0;
        int right = input.length - 1;
        if (target == input[minIndex]) {
            return minIndex;
        } else if (target > input[minIndex] && target <= input[right]) {
            left = minIndex;
        } else {
            right = minIndex;
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
        return left;
    }

    //4,5,6,7,8,9,1,2,3
    //input[4]
    //left = 5;
    // right = 6
    int findMin(int[] input) {
        int left = 0;
        int right = input.length - 1;
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (input[mid] < input[right]) {
                right = mid;
            } else if (input[mid] > input[right]) {
                left = mid + 1;
            }
        }
        return left;
    }
}
