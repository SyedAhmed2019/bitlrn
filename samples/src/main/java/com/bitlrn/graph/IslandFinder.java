package com.bitlrn.graph;

import java.util.*;

public class IslandFinder {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter row size of matrix");
        int row = scanner.nextInt();
        System.out.println("enter col size of matrix");
        int col = scanner.nextInt();
        Matrix matrix = new Matrix(row, col);
        matrix.createMatrix();
        matrix.displayMatrix();


        IslandFinder iFinder = new IslandFinder();
       /* List<Matrix.Coordinate> island = iFinder.findIslands(matrix);
        island.forEach(System.out::println);

        int currentIndex = 0;
        int islandCount = 0;
        while (currentIndex < island.size()){
            Matrix.Coordinate currentCoord = island.get(currentIndex);
            List<Matrix.Coordinate> neighbors = matrix.getNeighbors(currentCoord.x, currentCoord.y);
            for(int i=0; i < island.size(); ++i){
                if (currentIndex != i){
                    if((island.get(i).x != currentCoord.x+1 && island.get(i).y != currentCoord.y+1)
                      && neighbors.contains(island.get(i))){
                        continue;
                    }else{
                        islandCount++;
                        break;
                    }
                }
            }
        }

        System.out.println("number of islands "+(islandCount));*/

        iFinder.findIslands(matrix.listMatrix());

    }

    private List<Matrix.Coordinate> findIslands(Matrix matrix) {
        List<Matrix.Coordinate> visited = new ArrayList<>();
        Matrix.Coordinate root = new Matrix.Coordinate(0, 0);
        root.x = 0;
        root.y = 0;
        Deque<Matrix.Coordinate> queue = new ArrayDeque<>();
        queue.add(root);
        List<Matrix.Coordinate> island = new ArrayList<>();
        while (!queue.isEmpty()) {
            Matrix.Coordinate current = queue.pop();
            if (!visited.contains(current)) {
                if (current.getValue() == 1) {
                    island.add(current);
                }
                visited.add(current);
            }
            for (Matrix.Coordinate neighbor : matrix.getNeighbors(current.x, current.y)) {
                if (!visited.contains(neighbor)) {
                    if (neighbor.getValue() == 1) {
                        island.add(neighbor);
                    }
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return island;
    }


    private void findIslands(List<List<Integer>> input) {
        int rowSize = input.size();
        int colSize = input.get(0).size();
        int count = 0;
        for (int row = 0; row < rowSize; ++row) {
            for (int col = 0; col < colSize; ++col) {
                if (input.get(row).get(col) == 0) {
                    continue;
                }
                findIsland(input, row, col);
                count++;
            }
        }
        System.out.println("Number of islands" + count);
    }

    private void findIsland(List<List<Integer>> input, int row, int col) {
        Deque<Matrix.Coordinate> queue = new ArrayDeque<>();
        Matrix.Coordinate coordinate = new Matrix.Coordinate(row, col);
        coordinate.x = row;
        coordinate.y = col;
        queue.add(coordinate);
        while (!queue.isEmpty()) {
            Matrix.Coordinate current = queue.pop();
            input.get(current.x).set(current.y, 0);

            List<Matrix.Coordinate> neighbors = findNeighbors(current.x, current.y, input.size(), input.get(0).size());
            System.out.println("--- neighbors of [" + current.x + "," + current.y + "]----------");
            neighbors.forEach(System.out::println);

            for (Matrix.Coordinate neighbor : neighbors) {
                if (input.get(neighbor.x).get(neighbor.y) != 0) {
                    queue.add(neighbor);
                    input.get(neighbor.x).set(neighbor.y, 0);
                }
            }
        }
    }

    private List<Matrix.Coordinate> findNeighbors(int row, int col, int rowMax, int colMax) {
        List<Matrix.Coordinate> result = new ArrayList<>();
        int rowLeftLimit = -1;
        int rowRightLimit = -1;
        int colLeftLimit = -1;
        int colRightLimit = -1;
        // rwo boundaries
        if (row - 1 < 0) {
            rowLeftLimit = 0;
        } else {
            rowLeftLimit = row - 1;
        }
        if (row + 1 >= rowMax) {
            rowRightLimit = rowMax - 1;
        } else {
            rowRightLimit = row + 1;
        }
        // col boundaries
        if (col - 1 < 0) {
            colLeftLimit = 0;
        } else {
            colLeftLimit = col - 1;
        }
        if (col + 1 >= colMax) {
            colRightLimit = colMax - 1;
        } else {
            colRightLimit = col + 1;
        }

        for (int i = rowLeftLimit; i <= rowRightLimit; ++i) {
            for (int j = colLeftLimit; j <= colRightLimit; ++j) {
                if (i == row && j == col) {
                    continue;
                } else {
                    result.add(new Matrix.Coordinate(i, j));
                }
            }
        }
        return result;
    }
}
