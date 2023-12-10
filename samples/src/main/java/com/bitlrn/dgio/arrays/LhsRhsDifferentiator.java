package com.bitlrn.dgio.arrays;

/**
 * Take the sum of all elements to the left of index i in array nums (denoted as leftSum[i]),
 * and subtract it from the sum of all elements to the right of index i
 * in array nums (denoted as rightSum[i]), taking the absolute value of the result.
 */
public class LhsRhsDifferentiator {

    public static void main(String[] args) {
        LhsRhsDifferentiator differ = new LhsRhsDifferentiator();
        // answer should be 1,1,0
        int[] a = differ.findDifferenceArray(new int[]{-1, 1, 0});
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }

    }

    public int[] findDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] differenceArray = new int[n];
        int[] rightArray = new int[n];
        // TODO: Write your code here
        int leftSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            differenceArray[i] = nums[i] + leftSum;
            leftSum += nums[i];
        }
        int rightSum = 0;
        //   10 , 9, 7, 4
        for (int j = nums.length - 1; j >= 0; --j) {
            rightArray[j] = nums[j] + rightSum;
            rightSum += nums[j];
        }
        for (int i = 0; i < nums.length; ++i) {
            differenceArray[i] = Math.abs(rightArray[i] - differenceArray[i]);
        }

        return differenceArray;
    }
}
