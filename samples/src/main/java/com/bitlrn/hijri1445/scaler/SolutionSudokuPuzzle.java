package com.bitlrn.hijri1445.scaler;

import java.util.ArrayList;

public class SolutionSudokuPuzzle {
    public static void main(String[] args) {
        SolutionSudokuPuzzle ssp = new SolutionSudokuPuzzle();
        ssp.solveSudoku(null);
    }

    public boolean checkAvailable(Character[][] puzzle, int row, int col, int val) {
        // row
        for (int i = 0; i < puzzle.length; ++i) {
            if (puzzle[row][i] == (char) (val + '0')) {
                return false;
            }
        }

        //col
        for (int i = 0; i < puzzle.length; ++i) {
            if (puzzle[i][col] == (char) (val + '0')) {
                return false;
            }
        }

        // 3 * 3
        int currRow = row - row % 3;
        int currCol = col - col % 3;
        for (int i = currRow; i <= currRow + 2; i++) {
            for (int j = currCol; j <= currCol + 2; j++) {
                if (puzzle[i][j] == (char) (val + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(Character[][] puzzle, int row, int col) {
        if (row == puzzle.length) {
            //display(puzzle);
            return true;
        }
        int nRow = (col == puzzle.length - 1) ? row + 1 : row;
        int nCol = (col == puzzle.length - 1) ? 0 : col + 1;

        if (puzzle[row][col] == '.') {
            for (int i = 1; i <= 9; ++i) {
                if (checkAvailable(puzzle, row, col, i)) {
                    puzzle[row][col] = (char) (i + '0');
                    if (solve(puzzle, nRow, nCol)) {
                        return true;
                    }
                    puzzle[row][col] = '.';
                }
            }
        } else {
            return solve(puzzle, nRow, nCol);
        }

        return false;

    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
       /* Character [][] sudoPuzzle = new Character[9][];
        int i=0;
        for(ArrayList<Character> current:a){
            sudoPuzzle[i++] = current.toArray(new Character[0]);
        }*/
        Character[][] sudoPuzzle = create('.');
        solve(sudoPuzzle, 0, 0);
    }

    private void display(Character[][] newSudoPuzzle) {
        for (int row = 0; row < newSudoPuzzle.length; ++row) {
            for (int col = 0; col < newSudoPuzzle.length; ++col) {
                System.out.print(newSudoPuzzle[row][col] + " ");
            }
            System.out.println();
        }
    }

    private Character[][] create(char blankChar) {
        Character[][] sudokuPuzzle = new Character[9][9];
        Character[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
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
}

