package com.bitlrn.graph;

import java.util.*;

public class MineSweeper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MineSweeper ms = new MineSweeper();
        // ask to user rows?
        int rowSize = scanner.nextInt();
        // ask to user cols
        int colSize = scanner.nextInt();

        // populate the values of m * n matrix using user input
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rowSize; ++i) {
            List<Integer> cols = new ArrayList<>();
            for (int j = 0; j < colSize; ++j) {
                int currentValue = scanner.nextInt();
                if (currentValue == -2) {
                    currentValue = Integer.MAX_VALUE;
                }
                cols.add(currentValue);
            }
            matrix.add(i, cols);
        }

        // display matrix
        ms.displayMatrix(matrix);
        ms.calculateGateSteps(matrix);
        ms.displayMatrix(matrix);

    }

    private void calculateGateSteps(List<List<Integer>> matrix) {
        Coordinate first = new Coordinate(0, 0, matrix.get(0).get(0));
        List<Coordinate> visited = new ArrayList<>();
        Deque<Coordinate> queue = new ArrayDeque();
        queue.add(first);
        int steps = 0;
        while (!queue.isEmpty()) {
            Coordinate current = queue.pop();
            if (!visited.contains(current)) {
                visited.add(current);
            }
            if (current.value == Integer.MAX_VALUE) {
                matrix.get(current.x).set(current.y, 0);
            } else if (current.value > 0) {
                matrix.get(current.x).set(current.y, 1 + matrix.get(current.x).get(current.y));
            }
            System.out.println("current:[" + current.x + "," + current.y + "]");
            for (Coordinate neighbor : getNeighbor(matrix, current)) {
                if (visited.contains(neighbor)) {
                    continue;
                }
                queue.add(neighbor);
                visited.add(neighbor);
            }
            steps++;
        }
    }

    private List<Coordinate> getNeighbor(List<List<Integer>> matrix, Coordinate current) {
        List<Coordinate> results = new ArrayList<>();
        int[] rowDelta = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] colDelta = {0, 1, 1, 1, 0, -1, -1, -1};
        Coordinate latest = null;
        for (int i = 0; i < rowDelta.length; ++i) {
            if ((current.x + rowDelta[i] < 0 || current.y + colDelta[i] < 0)
                    || (current.x + rowDelta[i] >= matrix.size()) || current.y + colDelta[i] >= matrix.get(0).size()) {
                continue;
            }
            results.add(new Coordinate(current.x + rowDelta[i], current.y + colDelta[i],
                    matrix.get(current.x + rowDelta[i]).get(current.y + colDelta[i])));
        }
        System.out.println("Neighbors are " + results);
        return results;
    }

    private void displayMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); ++i) {
            System.out.println(matrix.get(i));
        }
    }

    class Coordinate {
        int x;
        int y;

        int value;

        public Coordinate(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "[" + this.x + "," + this.y + "]=" + this.value;
        }
    }
}
