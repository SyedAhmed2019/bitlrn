package com.bitlrn.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fifo {
    private final List<Integer> fifoQ = new ArrayList<>();
    private int front = 0;
    private int rear = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fifo queue = new Fifo();
        while (true) {
            System.out.println("Select operation to perform on Q\n 0. Exit (enter 0) \n 1. Insert(enter 1)\n 2. Remove (enter 2)\n 3. Peek (enter 3) ");
            int input = scanner.nextInt();
            if (input <= 3) {
                Fifo.Operation operation = Fifo.Operation.values()[input];
                switch (operation) {
                    case EXIT:
                        System.out.println("Goodbye!");
                        return;
                    case INSERT:
                        System.out.println("Enter the value to be inserted:");
                        queue.insert(scanner.nextInt());
                        break;
                    case REMOVE:
                        int remove = queue.remove();
                        if (remove != -1) {
                            System.out.println("Removed value is:" + remove);
                        }
                        break;
                    case PEEK:
                        int peek = queue.peek();
                        if (peek != -1) {
                            System.out.println("Peeked value is " + queue.peek());
                        }
                        break;
                }
            } else {
                System.out.println("wrong input!!!");
            }
        }
    }

    private int peek() {
        if (front != rear) {
            return fifoQ.get(front);
        } else {
            System.out.println("No items in Q to peek");
        }
        return -1;
    }

    private int remove() {
        if (front >= 0) {
            return fifoQ.remove(front++);
        } else {
            System.out.println("No items in Q to remove");
        }
        return -1;
    }

    private void insert(int item) {
        if (front == rear) {
            rear = 0;
            front = 0;
        }
        fifoQ.add(rear++, item);
    }

    enum Operation {
        EXIT,
        INSERT,
        REMOVE,
        PEEK,
    }
}
