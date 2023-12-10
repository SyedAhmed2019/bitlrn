package com.bitlrn.binarysearch;

import java.util.List;


public class BinarySearchProblemSet {
    public static void main(String[] args) {
        BinarySearchProblemSet bps = new BinarySearchProblemSet();
        //bps.testFindFirstTrueValue();
        //bps.testFindLargeAfterTarget();
        //bps.testFindFirstIndexOfDuplicateTarget();
        //bps.testFindMinInRotatedArray();
        bps.testFindMountainPeak();

    }

    private void testFindMountainPeak() {
        List<Integer> input1 = List.of(1, 3, 2);
        List<Integer> input2 = List.of(10, 20, 30, 80, 90, 60, 50);
        System.out.println(findMountainPeakInArray(input1));
        System.out.println(findMountainPeakInArray(input2));
    }

    private int findMountainPeakInArray(List<Integer> input) {
        int low = 0;
        int high = input.size() - 1;
        int peakIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == input.size() - 1 || input.get(mid) >= input.get(mid + 1)) {
                peakIndex = mid;
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return peakIndex;
    }

//=========================================== Problem 1 ==========================

    /**
     * Given an array of integers sorted in increasing order and a target, find the index of the first element in the array that is larger than or equal to the target. Assume that it is guaranteed to find a satisfying number.
     * <p>
     * Input:
     * arr = [1, 3, 3, 5, 8, 8, 10]
     * target = 2
     * Output: 1
     */

    private int findLargeAfterTarget(List<Integer> simple, int target) {
        int low = 0;
        int high = simple.size() - 1;
        int currentIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (simple.get(mid) >= target) {
                currentIndex = mid;
                high = mid - 1;
            } else if (simple.get(mid) < target) {
                low = mid + 1;
            }
        }
        return currentIndex;
    }

    private void testFindLargeAfterTarget() {
        List<Integer> simple = List.of(1, 3, 4, 4, 7, 9);
        System.out.println(findLargeAfterTarget(simple, 5));
        List<Integer> negative = List.of(1, 2, 2, 2, 2, 2, 2, 3);
        System.out.println(findLargeAfterTarget(negative, 2));
    }

//=========================================== Problem  2==========================

    /**
     * Given a sorted array with false on left side and then true on the right side.
     * find efficiently the index of first true value or -1 if no true values
     * e.g.
     * f f f f f  t t t t  -- returns 5
     * brute force will result in O(n) TC. Using Binary Search results in logN TC.
     */
    private int findFirstTrueValue(List<Boolean> values) {
        if (values.get(0)) {
            return 0;
        }
        if (values.size() == 1) {
            return values.get(0) ? 0 : -1;
        }
        int left = 0;
        int right = values.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!values.get(mid)) {
                left = mid + 1;
            } else {
                if (mid > 0 && !values.get(mid - 1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    void testFindFirstTrueValue() {
        // test 1
        List<Boolean> normalBoolValues = List.of(false, false, false, true, true, true);
        // test 2 - no true values
        List<Boolean> noTrueValues = List.of(false);
        // test 3 = single true value
        List<Boolean> singleTrueValue = List.of(true);
        //test 4
        List<Boolean> lastTrueValue = List.of(false, false, false, false, false, false, true);
        //test 5
        List<Boolean> mostlyTrueValues = List.of(false, true, true, true);

        List<Boolean> allfalse = List.of(false, false, false);

        List<Boolean> allTrue = List.of(true, true, true);

        BinarySearchProblemSet bsps = new BinarySearchProblemSet();
        System.out.println(bsps.findFirstTrueValue(normalBoolValues));
        System.out.println(bsps.findFirstTrueValue((noTrueValues)));
        System.out.println(bsps.findFirstTrueValue(singleTrueValue));
        System.out.println(bsps.findFirstTrueValue((lastTrueValue)));
        System.out.println(bsps.findFirstTrueValue(mostlyTrueValues));
        System.out.println(bsps.findFirstTrueValue((allfalse)));
        System.out.println(bsps.findFirstTrueValue(allTrue));

    }

    //=========================================== Problem  3==========================

    /**
     * Given an array of integers sorted in increasing order and a target, find the index of the first element in the array that is larger than or equal to the target. Assume that it is guaranteed to find a satisfying number.
     * <p>
     * Input:
     * <p>
     * arr = [1, 3, 3, 5, 8, 8, 10]
     * target = 2
     * Output: 1
     */

    private int findFirstIndexOfDuplicatedTarget(List<Integer> input, int target) {
        int low = 0;
        int high = input.size() - 1;
        int currentIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (input.get(mid) == target) {
                currentIndex = mid;
                high = mid - 1;
            } else if (input.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return currentIndex;
    }

    private void testFindFirstIndexOfDuplicateTarget() {
        List<Integer> simple = List.of(1, 2, 2, 3, 3, 3, 4, 4, 5);
        System.out.println(findFirstIndexOfDuplicatedTarget(simple, 3));
        System.out.println(findFirstIndexOfDuplicatedTarget(simple, 1));
        System.out.println(findFirstIndexOfDuplicatedTarget(simple, 5));
        System.out.println(findFirstIndexOfDuplicatedTarget(simple, 4));
    }

    //=========================================== Problem  4==========================

    /**
     * A sorted array of unique integers was rotated at an unknown pivot. For example, [10, 20, 30, 40, 50] becomes [30, 40, 50, 10, 20]. Find the index of the minimum element in this array.
     * Input: [30, 40, 50, 10, 20]
     * Output: 3
     * Explanation: the smallest element is 10 and its index is 3.
     * Input: [3, 5, 7, 11, 13, 17, 19, 2]
     * Output: 7
     * Explanation: the smallest element is 2 and its index is 7.
     */

    private void testFindMinInRotatedArray() {
        List<Integer> input1 = List.of(30, 40, 50, 10, 20);
        List<Integer> input2 = List.of(2, 3, 4, 5, 6, 7, 8, 9, 1);
        List<Integer> input3 = List.of(10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(findMinInRotatedArray(input1));
        System.out.println(findMinInRotatedArray(input2));
        System.out.println(findMinInRotatedArray(input3));

    }

    private int findMinInRotatedArray(List<Integer> input) {
        int low = 0;
        int high = input.size() - 1;
        int prevIndex = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (input.get(mid) <= input.get(input.size() - 1)) {
                prevIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return prevIndex;
    }


}
