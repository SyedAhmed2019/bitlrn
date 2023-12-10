package com.bitlrn.arrays.sort;

public class Sort {
    private final int[] mergeScratch = new int[10];

    /**
     * Works starting with first element being mininum
     * and iterating to find the element least than the mininum,
     * and swap them.  Do it for all elements
     * Time complexity O(n^2)
     *
     * @param a
     * @param descending
     */
    public void selectionSort(int[] a, boolean descending) {
        for (int i = 0; i < a.length; ++i) {
            int current = i;
            for (int j = i; j < a.length; ++j) {
                if (!descending) {
                    if (a[i] > a[j]) {
                        current = j;
                    }
                } else {
                    if (a[i] < a[j]) {
                        current = j;
                    }
                }
            }
            swap(a, i, current);
        }
    }

    /**
     * Compares with successor if it is less than the current, swap
     * Repeat it for entire array each time comparing with the next element
     * Time Complexity - worst case is O(N^2), best case is O(N) achieved
     * by breaking if there was no swap at first iteration itself.
     *
     * @param a
     * @param descending
     */
    public void bubbleSort(int[] a, boolean descending) {
        boolean swapped = false;
        for (int i = 0; i < a.length; ++i) {
            swapped = false;
            for (int j = 0; j < a.length - 1; ++j) {
                if (!descending) {
                    if (a[j] > a[j + 1]) {
                        swap(a, j, j + 1);
                        swapped = true;
                    }
                } else {
                    if (a[j] < a[j + 1]) {
                        swap(a, j, j + 1);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }

        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Loops to entire array elements, comparing and moving the elements
     * from lowest to highest order as needed.
     * Worst Case is O(N^2)
     * Best Case is O(N)
     *
     * @param a
     * @param decrease
     */
    public void insertionSort(int[] a, boolean decrease) {
        for (int i = 1; i < a.length; ++i) {
            int current = a[i];
            int j = i - 1;
            if (!decrease) {
                while (j >= 0 && a[j] > current) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = current;
            } else {
                while (j >= 0 && a[j] < current) {
                    a[j + 1] = a[j];
                    j = j - 1;
                }
                a[j + 1] = current;
            }
        }
    }

    /**
     * Use the merge sort method to sort the array a
     * It does by dividing into subarrays and sorting/merging them
     * Time Complexity : O(NlogN)
     *
     * @param a
     * @param low
     * @param high
     */
    public void mergeSort(int[] a, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        int i = low;
        int j = mid + 1;
        if (high + 1 - low >= 0) System.arraycopy(a, low, mergeScratch, low, high + 1 - low);
        int k = low;
        while (k <= high) {
            if (i <= mid && j <= high) {
                a[k] = Math.min(mergeScratch[i], mergeScratch[j]);
                if (a[k] == mergeScratch[i]) {
                    i++;
                } else {
                    j++;
                }
            } else if (i <= mid && j > high) {
                a[k] = mergeScratch[i];
                i++;
            } else {
                a[k] = mergeScratch[j];
                j++;
            }
            k++;
        }
    }

    public void mergeSortWithLog(int[] a, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortWithLog(a, low, mid);
        mergeSortWithLog(a, mid + 1, high);

        int i = low;
        int j = mid + 1;
        System.out.println("Current i (low) =" + i);
        System.out.println("Current j(mid+1)=" + j);
        // here we are currently copying the current
        // unsorted elements.
        System.out.println("Current unsorted elements: low=" + low + " high=" + high);
        for (int k = low; k <= high; k++) {
            mergeScratch[k] = a[k];
            System.out.print(" " + mergeScratch[k]);
        }
        System.out.println();
        int k = low;
        System.out.println("Starting K with value of low " + k);
        while (k <= high) {
            if (i <= mid && j <= high) {
                System.out.println("Comparing and assigning lower of scratch[" + i + "](scratch[i]=" + mergeScratch[i] + ") and scratch[" + j + "](scratch[j]=" +
                        mergeScratch[j] + ") to a[" + k + "](a[k]=" + a[k] + ")");
                a[k] = Math.min(mergeScratch[i], mergeScratch[j]);
                System.out.println("Is a[" + k + "]=" + a[k] + " equal to scratch[" + i + "]=" + mergeScratch[i] + "?");
                if (a[k] == mergeScratch[i]) {
                    i++;
                    System.out.println("Yes. Incremented i to new value " + i);
                } else {
                    j++;
                    System.out.println("No. Incremented j to new value " + j);
                }
            } else if (i <= mid && j > high) {
                System.out.println(i + " i is <= mid " + mid + " j (> high) is = " + j);
                System.out.println("a[k]=" + a[k] + " will be replaced by scratch[i]=" + mergeScratch[i]);
                a[k] = mergeScratch[i];
                i++;
                System.out.println("Incremented i to new value " + i);
            } else {
                System.out.println(i + " i is > mid " + mid + " j (<=high) is = " + j);
                System.out.println("a[k]=" + a[k] + " will be replaced by scratch[j]=" + mergeScratch[j]);
                a[k] = mergeScratch[j];
                j++;
                System.out.println("Incremented j to new value " + j);
            }
            k++;
            System.out.println(" new value of k after increment \n" + k);
        }
        System.out.println("Current Sorted sub array:");
        for (int x = low; x <= high; x++) {
            System.out.print(a[x] + " ");
        }
        System.out.println();
        System.out.println("next iteration");
    }

    /**
     * Takes a pivot (here the last element)
     * Starting from left, compare with pivot, when a small element is found
     * it is swapped with left most large element and finally the pivot gets
     * placed at its right position.
     * Repeat it again from leftmost to pivot correct position -1
     * and pivot_correct_position+1 to right
     * <p>
     * Time complexity : Worst Case is O(N^2)
     * Best Case is (O(NlogN)
     *
     * @param a
     * @param low
     * @param high
     */
    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = a[high];
            int i = low - 1;
            for (int j = low; j <= high - 1; ++j) {
                if (a[j] <= pivot) {
                    //swap using by incrementing i and j.
                    swap(a, ++i, j);
                }
            }
            swap(a, ++i, high);
            quickSort(a, low, i - 1);
            quickSort(a, i + 1, high);
        }
    }


}
