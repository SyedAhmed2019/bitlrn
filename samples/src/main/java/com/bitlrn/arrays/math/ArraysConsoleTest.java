package com.bitlrn.arrays.math;

import com.bitlrn.util.Util;

import java.util.List;

public class ArraysConsoleTest {
    static void testFindSum() {
        Arrays arrays = new Arrays();
        // test data 1
        Util.print(arrays.findSum(new int[]{1, 2, 3, 4, 5, 6}, 6));

        // test data 2
        Util.print(arrays.findSum(new int[]{6, 5, 4, 3, 2, 1, 8}, 14));

        // test data 3
        Util.print(arrays.findSum(new int[]{6, 5, 4, 3, 2, 1, 8}, 1));
    }

    static void testFindSumIndices() {
        Arrays arrays = new Arrays();
        // test data 1
        Util.print(arrays.findSumIndices(new int[]{1, 2, 3, 4, 5, 6}, 6));

        // test data 2
        Util.print(arrays.findSumIndices(new int[]{6, 5, 4, 3, 2, 1, 8}, 14));

        // test data 3
        Util.print(arrays.findSumIndices(new int[]{6, 5, 4, 3, 2, 1, 8}, 1));
    }

    static void testFindProductExceptItselfWithoutDivision() {
        Arrays arrays = new Arrays();
        // test data 1
        Util.print(Arrays.findProductWithoutDivision(new int[]{1, 2, 3, 4, 5, 6}));

        // test data 2
        Util.print(Arrays.findProductWithoutDivision(new int[]{6, 5, 4, 3, 2, 1, 8}));

        // test data 3
        Util.print(Arrays.findProductWithoutDivision(new int[]{6, 5, 4, 3, 2, 1, 8}));

        // test data 4
        Util.print(Arrays.findProductWithoutDivision(new int[]{6, 5, 4, 3, 2, 1, 0}));
    }

    static void testFindProductExceptItself() {
        Arrays arrays = new Arrays();
        // test data 1
        Util.print(arrays.findProductExceptItself(new int[]{1, 2, 3, 4, 5, 6}));

        // test data 2
        Util.print(arrays.findProductExceptItself(new int[]{6, 5, 4, 3, 2, 1, 8}));

        // test data 3
        Util.print(arrays.findProductExceptItself(new int[]{6, 5, 4, 3, 2, 1, 8}));

        // test data 4
        Util.print(arrays.findProductExceptItself(new int[]{6, 5, 4, 3, 2, 1, 0}));
    }

    private static void testFindMinimum() {
        Arrays arrays = new Arrays();
        System.out.println(arrays.findMinimum(new int[]{6, 5, 4, 3, 2, 1, 0}));

        System.out.println(arrays.findMinimum(new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static void testFindNonRepeatingNumber() {
        Arrays arrays = new Arrays();
        System.out.println(arrays.findFirstNonRepeatingNumber(new int[]{1, 1, 2, 2, 4, 5, 5}));
        System.out.println(arrays.findFirstNonRepeatingNumber(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(arrays.findFirstNonRepeatingNumber(new int[]{1, 2, 1, 4, 2, 6, 6}));
        System.out.println(arrays.findFirstNonRepeatingNumber(new int[]{4, 5, 1, 2, 0, 4}));
    }

    private static void testFindSecondLargestElement() {
        Arrays arrays = new Arrays();
        System.out.println(arrays.findSecondLargestElement(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(arrays.findSecondLargestElement(new int[]{6, 6, 5, 5, 4, 3}));
    }


    private static void testRotateAnArrayByOneIndex() {
        Arrays arrays = new Arrays();
        int[] a = new int[]{1, 2, 3, 4, 5, 6};
        arrays.rotateAnArrayByOneIndex(a);
        Util.print(a);
    }

    public static void main(String[] args) {
        // 1
        // testFindSum();

        // 2.
        // testFindSumIndices();

        // 3.
        //testFindProductExceptItself();

        //4.
        //testFindProductExceptItselfWithoutDivision();

        //5.
        //testFindMinimum();

        //6.
        //testFindNonRepeatingNumber();

        //8.
        //testFindSecondMaxRepeatingNumber();

        //9.
        // testFindSecondLargestElement();

        //10.
        // testRotateAnArrayByOneIndex();

        //11.
        //testRearrangeNegativePositive();

        //12.
        testRearrangeMaxMinForm();

        //13.
        //testSubArraySum();

    }

    private static void testSubArraySum() {
        Arrays arrays = new Arrays();
        int[] a = new int[]{1, 2, 3, 7, 5};
        List<Integer> result = arrays.subarraySum(a, a.length, 12);
        for (Integer item : result) {
            System.out.print(item + " ");
        }
    }

    private static void testRearrangeMaxMinForm() {
        Arrays arrays = new Arrays();
        int[] a = new int[]{-6, -5, -4, 1, 2, 3};
        arrays.rearrangeMaxMinForm(a);
        Util.print(a);

        a = new int[]{-6, -5, -4, 1, 2, 3, 4};
        arrays.rearrangeMaxMinForm(a);
        Util.print(a);

        a = new int[]{1, 2, 3, 4, 5};
        arrays.rearrangeMaxMinForm(a);
        Util.print(a);

        arrays.rearrangeMaxMinFormEfficient(a);
        Util.print(a);

        a = new int[]{24, 35, 46, 57, 68, 79, 80};
        arrays.rearrangeMaxMinFormEfficient(a);
        Util.print(a);

    }

    private static void testRearrangeNegativePositive() {
        Arrays arrays = new Arrays();
        int[] a = new int[]{1, 2, 3, -4, -5, -6};
        arrays.rearrangeNegativePositiveNumbers(a);
        Util.print(a);

        a = new int[]{-1, 2, -3, -5, 6};
        arrays.rearrangeNegativePositiveNumbers(a);
        Util.print(a);
    }
}
