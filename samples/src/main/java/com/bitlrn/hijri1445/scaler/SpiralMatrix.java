package com.bitlrn.hijri1445.scaler;

/**
 * Print the elements of matrix in Spiral fashion
 * [ 1 2 3 4]
 * [ 5 6 7 8]
 * [ 0 10 11 12]
 * [13 14 15 16]
 * <p>
 * printing should be a[0,0], a[0,1], a[0,2] a[0.3]
 * a[1.3] a[2,3] a[3,3]
 * a[3,2] a[3,1] a[3,0]
 * a[2,0] a[1,0]
 * a[1,1], a[1,2]
 * a[2,1] a[2,2]
 */
public class SpiralMatrix extends Matrix {
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        sm.populateMatrix();
        sm.displayMatrix("populated-one");
        //sm.displaySpiralNByN();
        sm.displaySpiralMByN();
    }

    private void displaySpiralNByN() {
        for (int i = 0; i < matrix.length / 2; ++i) {
            int row = i;
            int col = i;
            System.out.println("\nrow " + (row + 1));
            while (col < matrix.length - i) {
                System.out.print(matrix[row][col] + " ");
                col++;
            }
            System.out.println("\ncol " + col);
            col--;
            row = i + 1;
            while (row <= col) {
                System.out.print(matrix[row][col] + " ");
                row++;
            }
            System.out.println("\nrow " + row);
            row--;
            col--;
            while (col >= i) {
                System.out.print(matrix[row][col] + " ");
                col--;
            }
            col++;
            System.out.println("\ncol " + col);
            row--;
            while (row > i) {
                System.out.print(matrix[row][col] + " ");
                row--;
            }
        }
        if (matrix.length % 2 == 1) {
            System.out.println(matrix[matrix.length / 2][matrix.length / 2]);
        }
    }


    private void displaySpiralMByN() {
        int rowMax = matrix.length - 1;
        int colMax = matrix[0].length - 1;
        int count = 0;
        int rowMin = 0;
        int colMin = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        while (count < m * n) {
            // row

            for (int col = colMin; col <= colMax; ++col) {
                System.out.print(matrix[rowMin][col] + " ");
                count++;
            }
            System.out.println();
            if (count >= m * n) {
                break;
            }
            rowMin++;
            //col
            for (int row = rowMin; row <= rowMax; ++row) {
                System.out.print(matrix[row][colMax] + " ");
                count++;
            }
            System.out.println();
            if (count >= m * n) {
                break;
            }
            colMax--;
            //row
            for (int col = colMax; col >= colMin; col--) {
                System.out.print(matrix[rowMax][col] + " ");
                count++;
            }
            rowMax--;
            System.out.println();
            if (count >= m * n) {
                break;
            }
            // column
            for (int row = rowMax; row >= rowMin; --row) {
                System.out.print(matrix[row][colMin] + " ");
                count++;
            }
            colMin++;
            System.out.println();
            if (count >= m * n) {
                break;
            }
        }
    }
}
