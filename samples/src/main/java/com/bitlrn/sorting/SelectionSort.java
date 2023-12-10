package com.bitlrn.sorting;

import java.util.List;

/**
 * What is selection sort ?
 * Given an unsorted array, iterate to find the smallest number and swap it to the
 * front of the array.  Try to find out the next small number swap it to second position in array and so on
 * <p>
 * e.g.
 * 5 4 3 2 1  minIndex = 0 compare index 1 value with minIndex value, if its less then make minIndex = 1; continue
 * minIndex =2,
 * minIndex =3,
 * minIndex =4.
 * Once the minIndex is determined swap with 0. So after one traversal of array & swapping it looks like
 * 1 4 3 2 5
 * start second traversal with minIndex = 1 compare with index 2 value and make minIndex=2, continue
 * minIndex=3,
 * swap minIndex=3 with index 1
 * 1 2 3 4 5
 * third, fourth, fifth traversal don't need swap.
 */

public class SelectionSort extends BaseSort {

    public static void main(String[] args) {
        SelectionSort selSort = new SelectionSort();
        selSort.display(selSort.sort(selSort.getUnsortedItems()));
    }

    @Override
    protected List<Integer> sort(List<Integer> unsortedList) {
        for (int i = 0; i < unsortedList.size(); ++i) {
            int minIndex = i;
            for (int j = i + 1; j < unsortedList.size(); ++j) {
                if (unsortedList.get(j) < unsortedList.get(minIndex)) {
                    minIndex = j;
                }
            }
            // we found the minIndex swap
            if (minIndex != i) {
                int temp = unsortedList.get(minIndex);
                unsortedList.set(minIndex, unsortedList.get(i));
                unsortedList.set(i, temp);
            }
        }
        return unsortedList;
    }
}
