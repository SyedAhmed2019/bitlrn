package com.bitlrn.dgio.queue;

import com.bitlrn.dgio.stack.Stack;

import java.util.Scanner;

/**
 * You are given a queue data structure. Your task is to write an algorithm to reverse the order of its elements.
 */
public class ReverseQueue {

    public static CircularQueue<Integer> reverseQueue(CircularQueue<Integer> q) {
        Stack<Integer> stack = new Stack<>(q.getSize());
        int size = q.getSize();
        for (int i = 0; i < size; ++i) {
            stack.push(q.dequeue());
        }
        for (int i = 0; i < size; ++i) {
            q.queue(stack.pop());
        }
        return q;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the queue");
        int queueSize = scanner.nextInt();
        CircularQueue<Integer> queue = new CircularQueue<>(queueSize);
        for (int i = 1; i <= queueSize; ++i) {
            queue.queue(i);
        }
        queue.display();
        queue = reverseQueue(queue);
        queue.display();

    }
}
