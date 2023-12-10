package com.bitlrn.hijri1445.scaler;

import java.util.Scanner;

/**
 * Given an input A fill a matrix in spiral order till A*A elements
 */
public class SpiralOrderMatrix {

    public static void main(String[] args) {
        SpiralOrderMatrix som = new SpiralOrderMatrix();
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[][] matrix = new int[input][input];
        int current = 1;
        int rowMin = 0;
        int rowMax = input - 1;
        int colMin = 0;
        int colMax = input - 1;
        int count = 0;
        while (count < input * input) {
            // first row
            for (int col = colMin; col <= colMax && count < input * input; ++col) {
                matrix[rowMin][col] = current++;
                System.out.print(matrix[rowMin][col] + " ");
                count++;
            }
            System.out.println();
            rowMin++;
            // last column
            for (int row = rowMin; row <= rowMax && count < input * input; ++row) {
                matrix[row][colMax] = current++;
                System.out.print(matrix[row][colMax] + " ");
                count++;
            }
            System.out.println();
            colMax--;
            // last row ;
            for (int col = colMax; col >= colMin && count < input * input; --col) {
                matrix[rowMax][col] = current++;
                System.out.print(matrix[rowMax][col] + " ");
                count++;
            }
            System.out.println();
            rowMax--;
            for (int row = rowMax; row >= rowMin && count < input * input; row--) {
                matrix[row][colMin] = current++;
                System.out.print(matrix[row][colMin] + " ");
                count++;
            }
            colMin++;
            System.out.println();
        }
    }
}
