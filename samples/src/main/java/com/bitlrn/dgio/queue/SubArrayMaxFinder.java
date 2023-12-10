package com.bitlrn.dgio.queue;

import java.util.*;

/**
 * Given an integer array and an integer 'k', design an algorithm
 * to find the maximum for each and every contiguous subarray of size k.
 */
public class SubArrayMaxFinder {
    private final ArrayDeque<Integer> queue = new ArrayDeque<>();
    private final ArrayDeque<Integer> subArrayQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        SubArrayMaxFinder sbmf = new SubArrayMaxFinder();
        for (int item : sbmf.printMaxMine(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)) {
            System.out.print(item + " ");
        }
        System.out.println(" ");
        for (int item : sbmf.printMaxMine(new int[]{10, 9, 8, 7, 6, 5}, 2)) {
            System.out.print(item + " ");
        }
        System.out.println(" ");
        for (int item : sbmf.printMaxMine(new int[]{10, 9, 20, 8, 30, 5}, 2)) {
            System.out.print(item + " ");
        }

        System.out.println(" ");
        for (int item : sbmf.printMaxMine(new int[]{10, 9, 20, 8, 30, 5}, 1)) {
            System.out.print(item + " ");
        }
        System.out.println(" ");
        // solution printing.
        int[] arr = {12, 1, 78, 90, 57, 89, 56};
        int n = arr.length;
        int k = 3;
        sbmf.printMax(arr, n, k);

    }

    public List<Integer> printMaxMine(int[] arr, int k) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        while (i < arr.length) {
            queue.add(arr[i++]);
        }
        int currentMax = Integer.MIN_VALUE;
        // 1 2 3 4 5 k=3
        // 2 3 4 5
        // 3 4 5  curr = 2 , max =2  = 3 4 5 2
        // 4 5 2 curr = 3 , max = 3  = 4 5 2 3 result = 3
        int j = 0;
        while (!queue.isEmpty()) {
            if (j < k) {
                int current = queue.pollFirst();
                subArrayQueue.add(current);
                j++;
                if (j == k) {
                    currentMax = subArrayQueue.pop();
                    while (j - 1 > 0) {
                        int next = subArrayQueue.pop();
                        if (next > currentMax) {
                            currentMax = next;
                        }
                        subArrayQueue.addLast(next);
                        j--;
                    }
                    result.add(currentMax);
                    j = k - 1;
                }
            } else {
                j = 0;
            }
        }
        // ToDo: Write Your Code Here.
        queue.clear();
        subArrayQueue.clear();
        return result;
    }

    public void printMax(int[] arr, int n, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        //5 4 3 5 6 2 3 6 7  2 4  7
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()])
                deque.removeLast();

            deque.addLast(i);

            if (deque.peek() < i - k + 1)
                deque.removeFirst();

            if (i >= k - 1)
                System.out.print(arr[deque.peek()] + " ");
        }
        System.out.println();
    }
}
