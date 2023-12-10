package com.bitlrn.arrays.delete;

/**
 * All the problems that deal with removal of elements
 * from array are captured here.
 */
public class Arrays {

    public static void main(String[] args) {

        Arrays arrays = new Arrays();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b;
        b = arrays.removeAllEvenIntegerBruteForce(a);
        for (int i = 0; i < b.length; ++i) {
            System.out.println(b[i]);
        }
        b = arrays.removeAllEvenIntegerEff(a);
        for (int i = 0; i < b.length; ++i) {
            System.out.println(b[i]);
        }
    }

    /**
     * Brute force approach of preparing an array
     * with O(N) complexity and O(N) space complexity
     *
     * @param a input array
     * @return non-even integers returned array
     */
    public int[] removeAllEvenIntegerBruteForce(int[] a) {
        int[] result = new int[a.length];
        int count = 0;
        for (int i = 0, j = 0; i < a.length; ++i) {
            if (a[i] % 2 != 0) {
                result[j++] = a[i];
                count++;
            }
        }

        if (count > 0 && count != result.length) {
            int[] latest = new int[count];
            for (int i = 0, j = 0; i < result.length; ++i) {
                if (result[i] != 0) {
                    latest[j++] = result[i];
                }
            }
            return latest;
        } else if (count == result.length) {
            return result;
        } else {
            return new int[1];
        }
    }

    /**
     * Efficient approach of preparing an array
     * with O(N) complexity and O(M) space complexity
     * assuming there are M odd numbers;
     *
     * @param a input array
     * @return non-even integers returned array
     */
    public int[] removeAllEvenIntegerEff(int[] a) {
        int counter = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] % 2 == 1) {
                a[counter++] = a[i];
            }
        }
        int[] result = new int[counter];
        System.arraycopy(a, 0, result, 0, counter);
        return result;
    }
}
