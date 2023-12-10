package com.bitlrn.hijri1445.scaler;

/**
 * Given a N*N chessboard place N queens correctly
 */
public class NQueens extends Matrix {

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        //queens.populateMatrix();
        char[][] matrix = new char[8][8];
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix.length; ++col) {
                matrix[row][col] = '*';
            }
        }
        //queens.placeQueensNonOptimal(matrix,0);
        // 3. boolean arrays to track the already placed queen in
        // column
        // left diagonal
        // right diagonal

        queens.placeQueensOptimal(matrix, 0, new boolean[matrix.length], new boolean[2 * matrix.length - 1],
                new boolean[2 * matrix.length - 1]);
    }

    //
    //
    // [ 0 1 2 ]
    // [ 1 2 3 ]
    // [ 2 3 4 ]
    //
    // [0 -1 -2] -1 0  -1 + 3 -2
    // [1  0 -1] 0  1  0 + 3 -2
    // [2  1  0]  1  2 (3-1 +3 -
    //[][][]
    private void placeQueensOptimal(char[][] matrix, int row, boolean[] columnTracker, boolean[] diagonalLeft,
                                    boolean[] diagonalRight) {
        if (row == matrix.length) {
            print(matrix);
            System.out.println("=========");
            return;
        }
        for (int col = 0; col < matrix.length; ++col) {
            if (!columnTracker[col] && !diagonalRight[row + col]
                    && !diagonalLeft[row - col + matrix.length - 1]) {
                matrix[row][col] = 'Q';
                columnTracker[col] = true;
                diagonalRight[row + col] = true;
                diagonalLeft[row - col + matrix.length - 1] = true;
                placeQueensOptimal(matrix, row + 1, columnTracker, diagonalLeft, diagonalRight);
                matrix[row][col] = '*';
                columnTracker[col] = false;
                diagonalRight[row + col] = false;
                diagonalLeft[row - col + matrix.length - 1] = false;
            }
        }


    }

    private void placeQueensNonOptimal(char[][] matrix, int row) {
        if (row == matrix.length) {
            print(matrix);
            System.out.println("------------------");
            return;
        }
        for (int col = 0; col < matrix.length; ++col) {
            if (isSafe(matrix, row, col)) {
                matrix[row][col] = 'Q';
                placeQueensNonOptimal(matrix, row + 1);
                matrix[row][col] = '*';
            }
        }


    }

    private boolean isSafe(char[][] matrix, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (matrix[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < matrix.length; i--, j++) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


}
