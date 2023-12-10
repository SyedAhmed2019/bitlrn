package com.bitlrn.arrays.merge;

/**
 * Here we will have all merge and similar problems based on
 * arrays
 */
public class Arrays {
    public static void main(String[] args) {
        /*
         1 test data
         */
        int[] a = new int[]{1, 3, 4, 5};
        int[] b = new int[]{2, 6, 7, 8};
        Arrays arrays = new Arrays();
        int[] results = arrays.mergeArrays(a, b);
        arrays.print(results);

        // 2. test data
        a = new int[]{5, 6, 7, 8, 9, 10};
        b = new int[]{1, 2, 3};
        arrays.print(arrays.mergeArrays(a, b));

        // 2. test data
        a = new int[]{1, 2, 3, 5, 10};
        b = new int[]{5, 6, 8, 11, 12, 13, 18};
        arrays.print(arrays.mergeArrays(a, b));

        // 3. test data
        a = new int[]{-1, 0, 3, 5, 10, 12, 18};
        b = new int[]{-6, -5, 1, 2, 4, 11, 13, 15};
        arrays.print(arrays.mergeArrays(a, b));
    }

    /**
     * Given two sorted arrays, merge them into a single array
     *
     * @param a - first array
     * @param b - second array
     * @return combined sorted array
     */
    public int[] mergeArrays(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int firstArrayLength = a.length;
        int secondArrayLength = b.length;
        int[] results = new int[a.length + b.length];
        while (i < firstArrayLength && j < secondArrayLength) {
            if (a[i] > b[j]) {
                results[k++] = b[j++];
            } else {
                results[k++] = a[i++];
            }
        }

        while (i < firstArrayLength) {
            results[k++] = a[i++];
        }

        while (j < secondArrayLength) {
            results[k++] = b[j++];
        }
        return results;
    }

    public void print(int[] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
