package com.bitlrn.dgio.queue;

import java.util.Scanner;

/**
 * You're given an integer N. Your task is to generate all binary numbers from 1 to N
 * and return them as a list of strings.
 */
public class BinaryGenerator {
    private CircularQueue<String> queue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryGenerator bg = new BinaryGenerator();
        System.out.println("How many binary numbers you want?");
        String[] result = bg.generateBinaryNumbers(scanner.nextInt());
        for (String curr : result) {
            System.out.println(curr);
        }
    }

    public String[] generateBinaryNumbers(int n) {
        queue = new CircularQueue<>(n);
        queue.queue("1");
        String[] result = new String[n];
        //result[0] = 1   1
        // reuslt[1] = 10 2
        // result[2] = 11 3
        // result[3] = 100
        int i = 0;
        do {
            result[i] = queue.dequeue();
            queue.queue(result[i] + "0");
            queue.queue(result[i] + "1");
            i++;
        } while (i <= n - 3);
        while (!queue.isEmpty()) {
            if (i == n) {
                break;
            }
            result[i++] = queue.dequeue();
        }

        return result;
    }
}
