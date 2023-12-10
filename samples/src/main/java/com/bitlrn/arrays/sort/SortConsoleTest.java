package com.bitlrn.arrays.sort;

import com.bitlrn.util.Util;

public class SortConsoleTest {
    private static void testSelectionSort() {
        int[] a = {2, 6, 4, 5, 8, 7, 1};
        int[] expect = {1, 2, 4, 5, 6, 7, 8};
        Sort sort = new Sort();
        sort.selectionSort(a, false);
        Util.print(a);
        verify(a, expect);

        sort.selectionSort(a, true);
        Util.print(a);
        verify(a, new int[]{8, 7, 6, 5, 4, 2, 1});
    }

    private static void testBubbleSort() {
        int[] a = {2, 6, 4, 5, 8, 7, 1};
        int[] expect = {1, 2, 4, 5, 6, 7, 8};
        Sort sort = new Sort();
        sort.bubbleSort(a, false);
        Util.print(a);
        verify(a, expect);

        sort.bubbleSort(a, true);
        Util.print(a);
        verify(a, new int[]{8, 7, 6, 5, 4, 2, 1});
    }

    private static void verify(int[] a, int[] expect) {
        for (int i = 0; i < expect.length; ++i) {
            if (a[i] != expect[i]) {
                System.out.println("failed");
                return;
            }
        }
        System.out.println("passed");
    }

    public static void main(String[] args) {
        //testSelectionSort();
        //testBubbleSort();
        //testInsertSort();
        //testMergeSort();
        //testQuickSort();

    }

    private static void testQuickSort() {
        Sort sort = new Sort();
        int[] a = new int[]{8, 9, 6, 7, 4, 3, 1, 2, 5};
        sort.quickSort(a, 0, a.length - 1);
        Util.print(a);

        a = new int[]{-1, -5, 0, -2, 1, -1, 2, 4, 3};
        sort.mergeSort(a, 0, a.length - 1);
        Util.print(a);
    }

    private static void testMergeSort() {
        int[] a = {8, 9, 7, 6, 5, 4, 3, 2, 1};
        Sort sort = new Sort();
        sort.mergeSort(a, 0, a.length - 1);
        Util.print(a);

        a = new int[]{-1, -5, 0, -2, 1, -1, 2, 4, 3};
        sort.mergeSort(a, 0, a.length - 1);
        Util.print(a);
    }

    private static void testInsertSort() {
        Sort sort = new Sort();
        int[] a = new int[]{6, 4, 5, 3, 2, 1};
        sort.insertionSort(a, false);
        Util.print(a);
        verify(a, new int[]{1, 2, 3, 4, 5, 6});

        a = new int[]{1, 2, 3, 4, 5, 6, 7};
        sort.insertionSort(a, true);
        Util.print(a);
        verify(a, new int[]{7, 6, 5, 4, 3, 2, 1});


    }
}
