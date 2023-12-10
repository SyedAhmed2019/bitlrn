package com.bitlrn.beginner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[i] != a[j]) {
                a[i + 1] = a[j];
                i++;
            }
        }
        for (int x : a) {
            System.out.print(a[x] + " ");
        }
    }
}
