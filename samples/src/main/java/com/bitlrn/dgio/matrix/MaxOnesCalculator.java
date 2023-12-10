package com.bitlrn.dgio.matrix;

/**
 * We are given a binary matrix
 * that has dimensions (m \times n),
 * consisting of ones and zeros.
 * Our task is to determine the row that contains the highest number of ones
 * and return two values: the zero-based index of this row and the actual count of ones it possesses.
 * If there is a tie, i.e., multiple rows contain the same maximum number of ones,
 * we must select the row with the lowest index.
 */
public class MaxOnesCalculator {
    public static void main(String[] args) {
        int[][] mByn = {{1, 0, 0}, {1, 1, 0}};
        MaxOnesCalculator cal = new MaxOnesCalculator();
        int[] result = cal.findMaxOnesRow(mByn);
        System.out.println("rowIndex = " + result[0] + " " + "maxCount = " + result[1]);
    }

    public int[] findMaxOnesRow(int[][] mat) {
        int maxOnesIdx = 0;
        int maxOnesCount = 0;
        int currentRowCount = -1;
        for (int i = 0; i < mat.length; ++i) {
            currentRowCount = 0;
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    ++currentRowCount;
                }
            }
            if (currentRowCount > maxOnesCount) {
                maxOnesCount = currentRowCount;
                maxOnesIdx = i;
            }
        }
        return new int[]{maxOnesIdx, maxOnesCount};
    }
}
