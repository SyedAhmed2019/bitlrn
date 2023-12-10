package com.bitlrn.hijri1445.scaler;


public class SolutionNQueens {
    public static void main(String[] args) {
        SolutionNQueens solution = new SolutionNQueens();
        char[][] board = new char[1][1];
        solution.placeNQueens(board, 0, new boolean[board.length], new boolean[2 * board.length - 1], new boolean[2 * board.length - 1]);
    }

    void placeNQueens(char[][] board, int row, boolean[] filledColumn, boolean[] left, boolean[] right) {
        if (row == board.length) {
            show(board);
            System.out.println("=========");
            return;
        }
        for (int col = 0; col <= board.length - 1; ++col) {
            if (!filledColumn[col] && !right[row + col] && !left[row - col + board.length - 1]) {
                board[row][col] = 'Q';
                filledColumn[col] = true;
                right[row + col] = true;
                left[row - col + board.length - 1] = true;
                placeNQueens(board, row + 1, filledColumn, left, right);
                board[row][col] = '.';
                filledColumn[col] = false;
                right[row + col] = false;
                left[row - col + board.length - 1] = false;
            }
        }
    }

    private void show(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
