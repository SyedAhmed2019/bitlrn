package com.bitlrn.graph;

import java.util.*;

public class KnightsMover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     /*   System.out.println("Enter row size of the check board");
        int rowSize = scanner.nextInt();
        System.out.println("Enter row size of the check board");
        int colSize = scanner.nextInt();
        List<List<Integer>> input = new ArrayList<>();
        for(int i = 0; i < rowSize; ++i){
            List<Integer> columns = new ArrayList<>();
            for(int j=0; j < colSize; ++j){
                columns.add(j, scanner.nextInt());
            }
            input.add(i,columns);
        }*/
        System.out.println("Enter target location in form of x and y");
        String targetPosition = scanner.next();
        String[] targetCoord = targetPosition.split(",");
        int targetRow = Integer.parseInt(targetCoord[0]);
        int targetCol = Integer.parseInt(targetCoord[1]);
        KnightsMover km = new KnightsMover();

        System.out.println(shortestDistance(0, 0, targetRow, targetCol));

    }

    private static int shortestDistance(int row, int column, int targetRow, int targetCol) {
        Matrix.Coordinate coordinate = new Matrix.Coordinate(row, column);
        Deque<Matrix.Coordinate> queue = new ArrayDeque<>();
        queue.add(coordinate);
        int move = 0;
        Set<Matrix.Coordinate> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                Matrix.Coordinate current = queue.pop();
                visited.add(current);
                if (current.x == targetRow && current.y == targetCol) {
                    return move;
                }

                List<Matrix.Coordinate> cooridnates = findNeighbors(current.x, current.y);
                for (Matrix.Coordinate neighbor : cooridnates) {
                    if (visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            move++;
        }
        return move;
    }

    private static List<Matrix.Coordinate> findNeighbors(int row, int col) {
        List<Matrix.Coordinate> result = new ArrayList<>();

        //These are got from 8 position the knight can move
        int[] deltaRowPosition = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
        int[] deltaColPosition = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

        for (int i = 0; i < deltaRowPosition.length; ++i) {
            result.add(new Matrix.Coordinate(row + deltaRowPosition[i], col + deltaColPosition[i]));
        }

        return result;
    }
}
