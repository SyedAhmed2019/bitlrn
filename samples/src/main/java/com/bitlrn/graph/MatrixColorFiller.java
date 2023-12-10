package com.bitlrn.graph;

import java.util.*;

/**
 * fillcolor simulation
 * Given a M by N matrix A fill color at A[i][j] by replacing the current
 * number to the given number value and adjacent neighbors with the same value
 * <p>
 * e.g
 * [ 1  2  3  4  5
 * 6  13 9  10  11
 * 11 12 13 14  15
 * 16 17 13 13 20
 * ]
 * <p>
 * suppose we want to change A[2][2] which is 13  with value 100  -- after fill it will
 * look like
 * <p>
 * [  1  2  3  4  5
 * 6  100 9  10  11
 * 11 12 13 14  15
 * 16 17 100 100 20
 * ]
 */
public class MatrixColorFiller {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter row size of matrix");
        int row = scanner.nextInt();
        System.out.println("enter col size of matrix");
        int col = scanner.nextInt();
        Matrix matrix = new Matrix(row, col);
        matrix.createMatrix();
        matrix.displayMatrix();

        System.out.println("Enter the row index to fill color ");
        int rowIndex = scanner.nextInt();
        System.out.println("Enter the column index to fill color");
        int colIndex = scanner.nextInt();
        System.out.println("Enter the value of the color");
        int newValue = scanner.nextInt();

        MatrixColorFiller mcf = new MatrixColorFiller();
        mcf.fillColorBfs(matrix, rowIndex, colIndex, newValue);
        matrix.displayMatrix();

    }

    /**
     * This just fills the neighbor of the input rowIndex,colIndex ONLY
     */
    private void fillColor(Matrix matrix, int rowIndex, int colIndex, int newValue) {
        List<Matrix.Coordinate> neighbors = matrix.getNeighbors(rowIndex, colIndex);
        int currentValue = Matrix.matrix[rowIndex][colIndex];
        for (Matrix.Coordinate coordinate : neighbors) {
            if (coordinate.getValue() == currentValue) {
                coordinate.setValue(newValue);
            }
        }
        Matrix.matrix[rowIndex][colIndex] = newValue;
    }

    private void fillColorBfs(Matrix matrix, int rowIndex, int colIndex, int newValue) {
        //lets take the input rowIndex,colIndex as the BFS root
        List<Matrix.Coordinate> visited = new ArrayList<>();
        Matrix.Coordinate root = new Matrix.Coordinate(rowIndex, colIndex);
        root.x = rowIndex;
        root.y = colIndex;
        Deque<Matrix.Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Matrix.Coordinate current = queue.pop();
            visited.add(current);
            for (Matrix.Coordinate coordinate : matrix.getNeighbors(current.x, current.y)) {
                if (!visited.contains(coordinate)) {
                    if (coordinate.getValue() == root.getValue()) {
                        coordinate.setValue(newValue);
                    }
                    queue.add(coordinate);
                    visited.add(coordinate);
                }
            }
        }
        root.setValue(newValue);
    }
}
