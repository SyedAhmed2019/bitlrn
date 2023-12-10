package com.bitlrn.sorting;

import java.util.List;

/**
 * What is insertion sort?
 * Given a set of unsorted numbers, consider first number has sorted
 * compare it with second number, if second number is lesser than first number swap.
 * since we don't have less than first number, start again when checking third number
 * with second number, if its less swap third number & second number, then check second number
 * with first number, if its less swap again and so on..
 * <p>
 * e.g.
 * 5 4 3 2 1
 * first iteration: i = 0 - its consider already sorted
 * second iteration: i= 1  compare with i=0 if less swap and exit
 * 4 5 3 2 1
 * third iteration : i =2  compare with i=1, if less swap, then compare with i=1,
 * if less swap and so on
 * 4 3 5 2 1
 * 3 4 5 2 1
 * fourth iteration
 * 3 4 2 5 1
 * 3 2 4 5 1
 * 2 3 4 5 1
 * fifth iteration
 * 2 3 4 1 5
 * 2 3 1 4 5
 * 2 1 3 4 5
 * 1 2 3 4 5
 */
public class InsertionSort extends BaseSort {
    // 5 4 3 2 1
    // 4 5 3 2 1

    public static void main(String[] args) {
        InsertionSort insertSort = new InsertionSort();
        List<Integer> unsortedList = insertSort.getUnsortedItems();
        insertSort.display(insertSort.sort(unsortedList));
    }

    public List<Integer> sort(List<Integer> unsortedList) {
        for (int i = 0; i < unsortedList.size(); ++i) {
            int current = i;
            System.out.println(current);
            while (current > 0 && unsortedList.get(current) < unsortedList.get(current - 1)) {
                int temp = unsortedList.get(current);
                unsortedList.set(current, unsortedList.get(current - 1));
                unsortedList.set(current - 1, temp);
                current--;
            }
            System.out.println("list when i= " + i + " is " + unsortedList);
        }
        return unsortedList;
    }
}
