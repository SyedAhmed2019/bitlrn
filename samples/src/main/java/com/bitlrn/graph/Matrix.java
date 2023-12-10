package com.bitlrn.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Matrix {
    static int[][] matrix;
    private final Scanner scanner = new Scanner(System.in);
    private final int rowSize;
    private final int colSize;

    public Matrix(int row, int column) {
        rowSize = row;
        colSize = column;
        matrix = new int[rowSize][colSize];
    }

    public void createMatrix() {
        for (int i = 0; i < rowSize; ++i) {
            for (int j = 0; j < colSize; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < rowSize; ++i) {
            System.out.print("[");
            for (int j = 0; j < colSize; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public List<Coordinate> getNeighbors(int rowIndex, int colIndex) {
        List<Coordinate> coordinates = new ArrayList<>();
        // e.g.  neighbors of [2,2] in 5 * 5 matrix is
        int lowLimitRow = -1;
        int upperLimitRow = -1;
        int lowLimitCol = -1;
        int upperLimitCol = -1;
        if (rowIndex - 1 >= 0) {
            lowLimitRow = rowIndex - 1;
        } else {
            lowLimitRow = rowIndex;
        }
        if (rowIndex + 1 < this.rowSize) {
            upperLimitRow = rowIndex + 1;
        } else {
            upperLimitRow = rowIndex;
        }
        if (colIndex - 1 >= 0) {
            lowLimitCol = colIndex - 1;
        } else {
            lowLimitCol = colIndex;
        }
        if (colIndex + 1 < this.colSize) {
            upperLimitCol = colIndex + 1;
        } else {
            upperLimitCol = colIndex;
        }

        for (int i = lowLimitRow; i <= upperLimitRow; ++i) {
            for (int j = lowLimitCol; j <= upperLimitCol; ++j) {
                if (i == rowIndex && j == colIndex) {
                    continue;
                }
                Coordinate coordinate = new Coordinate(i, j);
                coordinate.x = i;
                coordinate.y = j;
                coordinates.add(coordinate);
            }
        }
        return coordinates;
    }

    public List<List<Integer>> listMatrix() {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rowSize; ++i) {
            List<Integer> columns = new ArrayList<>();
            for (int j = 0; j < colSize; ++j) {
                columns.add(matrix[i][j]);
            }
            result.add(i, columns);
        }
        return result;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getValue() {
            return matrix[x][y];
        }

        public void setValue(int newValue) {
            matrix[x][y] = newValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "[x=" + x + ", y=" + y + "]=" + getValue();
        }
    }


}
