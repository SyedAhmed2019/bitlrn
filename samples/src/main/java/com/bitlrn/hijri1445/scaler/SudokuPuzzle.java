package com.bitlrn.hijri1445.scaler;

public class SudokuPuzzle {
    public static void main(String[] args) {
        SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
        // blank positions on each row based on sum of row+co

        char blankChar = '*';
        char[][] newSudoPuzzle = sudokuPuzzle.create(blankChar);
        sudokuPuzzle.display(newSudoPuzzle);
        sudokuPuzzle.solve(newSudoPuzzle, 0, 0);
    }

    private void display(char[][] newSudoPuzzle) {
        for (int row = 0; row < newSudoPuzzle.length; ++row) {
            for (int col = 0; col < newSudoPuzzle.length; ++col) {
                System.out.print(newSudoPuzzle[row][col] + " ");
            }
            System.out.println();
        }
    }

    private char[][] create(char blankChar) {
        char[][] sudokuPuzzle = new char[9][9];
        char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int row = 0; row < sudokuPuzzle.length; ++row) {
            for (int col = 0; col < sudokuPuzzle.length; ++col) {
                if (col == row) {
                    sudokuPuzzle[row][col] = digits[row];
                } else {
                    sudokuPuzzle[row][col] = blankChar;
                }
            }
        }
        return sudokuPuzzle;
    }

    private boolean solve(char[][] sudoPuzzle, int row, int col) {
        if (row == sudoPuzzle.length) {
            display(sudoPuzzle);
            return true;
        }
        int nx = (col == sudoPuzzle.length - 1) ? row + 1 : row;
        int ny = (col == sudoPuzzle.length - 1) ? 0 : col + 1;
        if (sudoPuzzle[row][col] == '*') {
            for (int val = 1; val <= 9; ++val) {
                if (checkAvailable(sudoPuzzle, row, col, val)) {
                    sudoPuzzle[row][col] = (char) (val + '0');
                    if (solve(sudoPuzzle, nx, ny)) {
                        return true;
                    }
                    sudoPuzzle[row][col] = '*';
                }
            }
        } else {
            return solve(sudoPuzzle, nx, ny);
        }

        return false;

    }


    private boolean checkAvailable(char[][] sudoPuzzle, int row, int col, int val) {
        // col
        for (int i = 0; i < sudoPuzzle.length; ++i) {
            if (sudoPuzzle[row][i] == (char) (val + '0')) {
                return false;
            }
        }

        // row
        for (int i = 0; i < sudoPuzzle.length; ++i) {
            if (sudoPuzzle[i][col] == (char) (val + '0')) {
                return false;
            }
        }
        //3*3
        int currRow = row - row % 3;
        int currCol = col - col % 3;
        for (int i = currRow; i <= currRow + 2; ++i) {
            for (int j = currCol; j <= currCol + 2; ++j) {
                if (sudoPuzzle[i][j] == (char) (val + '0')) {
                    return false;
                }
            }
        }
        return true;
    }
}
