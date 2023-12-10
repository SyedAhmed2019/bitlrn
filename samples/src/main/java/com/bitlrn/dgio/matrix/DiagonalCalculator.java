package com.bitlrn.dgio.matrix;

/**
 * Given a square matrix (2D array), calculate the sum of its two diagonals.
 * The two diagonals in consideration are the primary diagonal that
 * spans from the top-left to the bottom-right and the secondary diagonal
 * that spans from top-right to bottom-left. If a number is part of both diagonals
 * (which occurs only for odd-sized matrices), it should be counted only once in the sum.
 */
public class DiagonalCalculator {

    public static int diagonalSum(int[][] mat) {
        int totalSum = 0;  // Initialize the total sum
        int lowRow = 0;
        int lowCol = 0;
        int highCol = mat[0].length - 1;
        for (int i = lowRow, j = lowCol, k = highCol; i < mat.length && k >= 0; ++i, ++j, k--) {
            totalSum += mat[i][j] + mat[i][k];
        }

        if (mat.length % 2 == 1) {
            totalSum -= mat[mat.length / 2][mat.length / 2];
        }
        return totalSum;  // Return the calculated total sum
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][]{{1, 2}, {3, 4}};
        int[][] input2 = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] input3 = new int[][]{{5}};

        System.out.println(diagonalSum(input1));
        System.out.println(diagonalSum(input2));
        System.out.println(diagonalSum(input3));
    }
}
