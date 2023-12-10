package com.bitlrn.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * What is merge sort ?
 * Given an unsorted array/list,  using divide and conquer approach, the array is divided into two approximately equal
 * halves
 * and the halves are further divided recursively following the dividing approach used in first round.
 * <p>
 * This is done till the array has single elements which are considered sort.  Once this stage is reached
 * merge of subarrays is done wherein the small values are put in first and then the large values.
 * e.g
 * 5 4 3 2 1
 * left = 0 right = 4
 * mid = 2
 * 5, 4, 3  mid = 1     2 1  <-- first round
 * 5 4  mid = 0  3  <-- firt left rcur   2  1 <, first right recur
 * 5  4  <-- second left recur  3  < second right recur
 * 4 5 <-- merge 1
 * 3            1, 2 <-- merge 2
 * 1,2,3 <-- merge 3
 * 1 2 3 4 5 < -- merge 4
 */
public class MergeSort extends BaseSort {

    // This is not part of the merge logic but to print out how many times merge is called.
    static int debugMergeCount = 0;

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> unsortedList = mergeSort.getUnsortedItems();
        mergeSort.display(mergeSort.sort(unsortedList));

        // This is capturing how it can be done if an array is passed.
        //mergeSort.display(List.of(mergeSort.sortUsingArray(unsortedList.toArray(new Integer[0]))));

    }

    private List<Integer> mergeSort(List<Integer> unsortedList, int left, int right) {
        if (right - left <= 1) {
            return unsortedList.subList(left, right);
        }
        int mid = (left + right) / 2;
        List<Integer> leftSide = mergeSort(unsortedList, left, mid);
        List<Integer> rightSide = mergeSort(unsortedList, mid, right);
        return merge(leftSide, rightSide);
    }

    private List<Integer> merge(List<Integer> leftSide, List<Integer> rightSide) {
        System.out.println("merge: " + (++debugMergeCount) + " left side:" + leftSide + " right side:" + rightSide);
        int leftPointer = 0;
        int rightPointer = 0;
        List<Integer> result = new ArrayList<>();
        while (leftPointer < leftSide.size() || rightPointer < rightSide.size()) {
            if (leftPointer == leftSide.size()) {
                result.add(rightSide.get(rightPointer));
                rightPointer++;
            } else if (rightPointer == rightSide.size()) {
                result.add(leftSide.get(leftPointer));
                leftPointer++;
            } else if (leftSide.get(leftPointer) <= rightSide.get(rightPointer)) {
                result.add(leftSide.get(leftPointer));
                leftPointer++;
            } else {
                result.add(rightSide.get(rightPointer));
                rightPointer++;
            }
        }
        System.out.println("merge: " + (debugMergeCount) + " result " + result);
        return result;
    }

    @Override
    protected List<Integer> sort(List<Integer> unsortedList) {
        return mergeSort(unsortedList, 0, unsortedList.size());
    }

    protected Integer[] sortUsingArray(Integer[] unsorted) {
        return mergeSortUsingArray(unsorted, 0, unsorted.length);
    }

    private Integer[] mergeSortUsingArray(Integer[] unsorted, int left, int right) {
        if (right - left <= 1) {
            Integer[] subArray = new Integer[1];
            subArray[0] = unsorted[left];
            return subArray;
        }
        int mid = (left + right) / 2;
        Integer[] leftSide = mergeSortUsingArray(unsorted, left, mid);
        Integer[] rightSide = mergeSortUsingArray(unsorted, mid, right);
        Integer[] result = new Integer[leftSide.length + rightSide.length];
        int leftMark = 0, rightMark = 0, resultindex = 0;
        while (leftMark < leftSide.length || rightMark < rightSide.length) {
            if (leftMark == leftSide.length) {
                result[resultindex++] = rightSide[rightMark++];
            } else if (rightMark == rightSide.length) {
                result[resultindex++] = leftSide[leftMark++];
            } else {
                if (leftSide[leftMark] <= rightSide[rightMark]) {
                    result[resultindex++] = leftSide[leftMark++];
                } else {
                    result[resultindex++] = rightSide[rightMark++];
                }
            }
        }
        return result;
    }
}
