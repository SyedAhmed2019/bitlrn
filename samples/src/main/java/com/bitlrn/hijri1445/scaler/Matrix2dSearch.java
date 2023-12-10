package com.bitlrn.hijri1445.scaler;

/**
 * Given a M * N matrix, search an element
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class Matrix2dSearch extends Matrix {
    public static void main(String[] args) {
        Matrix2dSearch matrixSearch = new Matrix2dSearch();
        int[][] input = new int[][]{
                {1, 2, 3, 4, 5},
                {11, 12, 13, 14, 15},
                {25, 26, 27, 28, 29},
                {40, 41, 44, 45, 55}
        };

        System.out.println(matrixSearch.search(input, 12));
        System.out.println(matrixSearch.search(input, 55));
        System.out.println(matrixSearch.search(input, 90));


    }

    boolean search(int[][] input, int target) {
        int rowMin = 0;
        int rowMax = input.length - 1;
        int colMin = 0;
        int colMax = input[0].length - 1;
        int cRow = rowMin;
        int cCol = colMax;
        while (cRow <= rowMax && cCol >= colMin) {
            if (input[cRow][cCol] == target) {
                return true;
            } else if (target < input[cRow][cCol]) {
                cCol--;
            } else {
                cRow++;
            }
        }

        return false;
    }
}
