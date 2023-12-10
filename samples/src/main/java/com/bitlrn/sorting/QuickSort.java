package com.bitlrn.sorting;

import java.util.List;

/**
 * What is QuickSort ?
 * An unsorted array is divided by utilizing the right most value as pivot. The partition is done
 * so that pivot gets placed at proper position in the array with lower values on the left
 * and higher values on the right. Once done left side is recurse again and right hand side is
 * recurse again. Till the entire array gets sorted out.
 * e.g.
 * 5 4 3 2 1   left =0 right=4 pivot[4] = 1
 * leftmost = 4 right = 0  -- this two values are swapped
 * 1 4 3 2 5   LHS : left =0 right=0  RHS: left 1 right 4
 * leftmost=4  rightmost = 1ec
 */

public class QuickSort extends BaseSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        List<Integer> unsortedList = quickSort.getUnsortedItems();
        quickSort.display(quickSort.sort(unsortedList));
    }

    private List<Integer> quickSort(List<Integer> unsortedList, int left, int right) {
        if (left < right) {
            int pivotLocation = partition(unsortedList, left, right);
            System.out.println("Latest before rcurse:" + unsortedList);
            System.out.println("first recurse: left:" + left + " right: " + (pivotLocation - 1));
            quickSort(unsortedList, left, pivotLocation - 1);
            System.out.println("second recurse: left:" + (pivotLocation + 1) + " right: " + right);
            quickSort(unsortedList, pivotLocation + 1, right);
        }
        return unsortedList;
    }

    private int partition(List<Integer> unsortedList, int left, int right) {
        //using the rightmost element as pivot
        int pivot = unsortedList.get(right);
        System.out.println("New Pivot is :" + pivot);
        int leftMost = left - 1;

        for (int i = left; i <= right - 1; ++i) {
            if (unsortedList.get(i) < pivot) {
                leftMost++;
                int temp = unsortedList.get(leftMost);
                unsortedList.set(leftMost, unsortedList.get(i));
                unsortedList.set(i, temp);
                System.out.println("********************************");
                System.out.println("after inner swap :" + unsortedList);
                System.out.println("********************************");
            }
        }
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("after for loop: " + unsortedList);
        leftMost++;
        int temp = unsortedList.get(leftMost);
        unsortedList.set(leftMost, unsortedList.get(right));
        unsortedList.set(right, temp);
        System.out.println("after pivot swap with leftmost" + unsortedList);
        System.out.println("pivot point : " + leftMost);
        System.out.println("+++++++++++++++++++++++++++++");

        return leftMost;
    }

    @Override
    protected List<Integer> sort(List<Integer> unsortedList) {
        return quickSort(unsortedList, 0, unsortedList.size() - 1);
    }
}
