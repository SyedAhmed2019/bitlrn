package com.bitlrn.dgio.arrays;

/**
 * Given an array of integers, return a new array where each element at index i of the new array is the product of all
 * the numbers in the original array except the one at i. You must solve this problem without using division.
 * [1,2,3,4,5]
 * [1,1,2,6,24]
 * [120,60,20,5,1]
 * [120,60,40,30,24]
 */

public class ProductOfArrayMinusSelf {
    int[] left;
    int[] right;

    public static void main(String[] args) {
        ProductOfArrayMinusSelf pams = new ProductOfArrayMinusSelf();
        for (int i : pams.productExceptSelf(new int[]{1, 2, 3, 4, 5})) {
            System.out.print(i + ",");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        left = new int[nums.length];
        right = new int[nums.length];
        int[] result = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;
        // find left product
        // 0 -> 1
        // 1 -> 1*1 = 1
        // 2 -> 1 *2 = 2
        // 3 --> 2 * 3 6
        // 4 -->> 6 * 4 = 24
        for (int i = 1; i < nums.length; ++i) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // lenght-1 4 --> 1
        // 3 = 1 &
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int i = 0; i <= nums.length - 1; ++i) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
