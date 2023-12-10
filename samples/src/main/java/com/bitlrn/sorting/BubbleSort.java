package com.bitlrn.sorting;

import java.util.List;

/**
 * What is bubble sort?
 * Give an unsorted array, in first traversal compare the first item to second item, if second item is less than
 * swap, compare second item with third item, if third item is less swap with second item and so on.
 * <p>
 * Repeat the traversals till there is no swap of items
 * <p>
 * e.g.
 * First Traversal
 * 5 4 3 2 1
 * 4 5 3 2 1
 * 4 3 5 2 1
 * 4 3 2 5 1
 * 4 3 2 1 5
 * Second Traversal
 * 3 4 2 1 5
 * 3 2 4 1 5
 * 3 2 1 4 5
 * Third traversal
 * 2 3 1 4 5
 * 2 1 3 4 5
 * Fourth traversal
 * 1 2 3 4 5
 */
public class BubbleSort extends BaseSort {
    public static void main(String[] args) {
        BubbleSort BubbleSort = new BubbleSort();
        List<Integer> unsortedList = BubbleSort.getUnsortedItems();
        BubbleSort.display(BubbleSort.sort(unsortedList));
    }

    @Override
    protected List<Integer> sort(List<Integer> unsortedList) {
        boolean swapped = false;
        for (int i = 0; i < unsortedList.size(); ++i) {
            for (int j = 0; j < unsortedList.size() - 1; ++j) {
                if (unsortedList.get(j + 1) < unsortedList.get(j)) {
                    int temp = unsortedList.get(j + 1);
                    unsortedList.set(j + 1, unsortedList.get(j));
                    unsortedList.set(j, temp);
                    swapped = true;
                }
            }
            System.out.println("unsorted list after inner loop " + unsortedList);
            if (!swapped) {
                break;
            }
        }
        return unsortedList;
    }
}
