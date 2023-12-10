package com.bitlrn.hijri1445.scaler;

import java.util.Scanner;

public abstract class Matrix {
    protected int[][] matrix = null;
    private final Scanner scanner = new Scanner(System.in);

    protected void displayMatrix(String message) {
        System.out.println(message);
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    protected void populateMatrix() {
        System.out.println("Enter row size of the matrix =");
        int rowSize = scanner.nextInt();
        System.out.println("Enter column size of the matrix =");
        int colSize = scanner.nextInt();
        populateMatrixMByN(rowSize, colSize);

    }

    protected void populateMatrixMByN(int m, int n) {
        matrix = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.println("Enter value of matrix at matrix[" + i + "][" + j + "]:");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

}
