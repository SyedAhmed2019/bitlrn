package com.bitlrn.beginner;

import com.bitlrn.util.Instrumentation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a sorted array try to find out the position of
 * a given element within the array.
 * Return -1 if the element is not found
 * Shows both iterative and recursive approach
 */
public class BinarySearch {
    private final Instrumentation instrumentation;

    public BinarySearch() {
        instrumentation = new Instrumentation();
    }

    public static void main(String[] args) {
        nonUserInput();
        //userInput();
    }

    private static void userInput() {
        BinarySearch bis = new BinarySearch();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of input array:");
        int inputSize = scanner.nextInt();
        int[] inputArray = new int[inputSize];
        int i = 0;
        System.out.println("Enter the sorted elements of input array ");
        while (i < inputSize) {
            System.out.println("Enter " + i + "element of input array:");
            inputArray[i++] = scanner.nextInt();
        }
        System.out.println("Enter the element to find in array:");
        int elem = scanner.nextInt();
        int pos = bis.findElementRecursive(inputArray, 0, inputArray.length - 1, elem);
        if (pos == -1) {
            System.out.println("Element " + elem + " was not found using recursive method");
        } else {
            System.out.println("Element " + elem + " was found at position " + pos + " in input array using recursive method");
        }
        pos = bis.findElementNonRecursive(inputArray, elem);
        if (pos == -1) {
            System.out.println("Element " + elem + " was not found using non-recursive method");
        } else {
            System.out.println("Element " + elem + " was found at position " + pos + " in input array using non-recursive method");
        }
    }

    private static void nonUserInput() {
        BinarySearch bis = new BinarySearch();
        int[][] inputLists = {{}, {0, 1}, {1, 2, 3}, {-2, 0, 3, 5, 8, 15}, {-19, 0, 3, 5, 9, 15}, {-1, 0, 3, 5, 9, 12}};
        int[] lookupList = {12, 1, 3, 8, 2, 2};
        for (int i = 0; i < inputLists.length; ++i) {
            System.out.println("input list :" + Arrays.toString(inputLists[i]));
            System.out.println("find element :" + lookupList[i]);
            System.out.println("result non-recursive:" + bis.findElementNonRecursive(inputLists[i], lookupList[i]));
            System.out.println("result recursive:" + bis.findElementRecursive(inputLists[i], 0, inputLists[i].length - 1, lookupList[i]));
            System.out.println("result iterative-efficient:" + bis.findElementIterative(inputLists[i], lookupList[i]));
        }
    }

    public int findElementNonRecursive(int[] input, int element) {
        int low = 0;
        int high = input.length - 1;
        instrumentation.increment();
        while (low < high) {
            if (element == input[low]) {
                return low;
            }
            if (element == input[high]) {
                return high;
            }
            int mid = (low + high) / 2;
            if (element > input[mid]) {
                instrumentation.increment();
                low = mid + 1;
            } else if (element == input[mid]) {
                instrumentation.increment();
                return mid;
            } else {
                instrumentation.increment();
                high = mid;
            }
        }
        return -1;
    }

    public int findElementRecursive(int[] input, int min, int max, int elem) {
        instrumentation.increment();
        if (min >= max) {
            return -1;
        }
        // are we lucky with min
        if (elem == input[min]) {
            return min;
        }
        //are we lucky with max
        if (elem == input[max]) {
            return max;
        }
        // is it in middle to max side
        if (elem > input[(min + max) / 2]) {
            return findElementRecursive(input, (min + max) / 2 + 1, max, elem);
        } else {
            // is it in min to middle
            return findElementRecursive(input, min, (min + max) / 2, elem);
        }
    }

    public int findElementIterative(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }
}
