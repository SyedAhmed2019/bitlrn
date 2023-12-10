package com.bitlrn.hijri1445.scaler;

/**
 * Given an N * N matrix rotate by 90* clock wise
 * [1 2 3 4 ]
 * [5 6 7 8 ]
 * [9 10 11 12 ]
 * [13 4 15 16 ]
 * <p>
 * 1 5 9 13
 * 2 6 10 4
 * 3 7 11 15
 * 4 8 12 16
 */
public class RotateMatrix extends Matrix {
    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        rm.populateMatrix();
        rm.displayMatrix("population");
        System.out.println("rotate by 90 degree results in ");
        rm.byRotatingItems();
        rm.displayMatrix("after rotating");
        rm.byTransposeApproach();


    }
    //
    // 1 2 3
    // 4 5 6
    // 7 8 9
    //
    // after step1
    // 1 4 7
    // 2 5 8
    // 3 6 9
    //
    // 1 4 7 11
    // 2 5 8 11
    // 3 6 9 11
    // 4 7 10 11
    //

    private void byTransposeApproach() {
        for (int i = 0; i < this.matrix.length - 1; i++) {
            for (int j = i + 1; j < this.matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        displayMatrix("transpose");
        // now we need to swap
        int left = 0;
        int right = matrix.length - 1;
        int leftRow;
        int rightRow;
        while (left < right) {
            leftRow = 0;
            rightRow = 0;
            while (leftRow < matrix.length) {
                int temp = matrix[leftRow][left];
                matrix[leftRow][left] = matrix[rightRow][right];
                matrix[rightRow][right] = temp;
                leftRow += 1;
                rightRow += 1;
            }
            left += 1;
            right -= 1;

        }

        displayMatrix("after rotation");
    }

    private void byRotatingItems() {
        for (int row = 0, column = this.matrix.length - 1; row < 2; ++row, --column) {

            int i = row;
            int j = row;
            int k = column;
            int l = column;
            int temp;

            while ((i < column) && (j < column) &&
                    (l > row)) {
                temp = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[l][i];
                this.matrix[l][i] = this.matrix[k][l];
                this.matrix[k][l] = this.matrix[j][k];
                this.matrix[j][k] = temp;
                j += 1;
                l -= 1;
            }
        }
    }
}
