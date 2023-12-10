package com.bitlrn.dgio.queue;

import java.util.Scanner;

public class CircularQueue<T extends Comparable<T>> {
    private final int size;
    private int front;
    private int rear;
    private final Object[] queue;

    public CircularQueue(int size) {
        queue = new Object[size];
        front = -1;
        rear = -1;
        this.size = size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" size of the queue = ");
        int size = scanner.nextInt();
        CircularQueue<Integer> queue = new CircularQueue<>(size);

        int input = -1;
        do {
            System.out.println(" 0- QUEUE, 1-DEQUEUE, 2- PEEK, 3-DISPLAY,4 - EXIT");
            input = scanner.nextInt();
            switch (Operation.values()[input]) {
                case QUEUE:
                    System.out.println("Enter value to queue:");
                    int newValue = scanner.nextInt();
                    queue.queue(newValue);
                    break;
                case DEQUEUE:
                    queue.dequeue();
                    break;
                case PEEK:
                    System.out.println(queue.peek());
                    break;
                case DISPLAY:
                    queue.display();
                    break;
                case EXIT:
                    return;
                default:
            }

        } while (input != 4);

    }

    private boolean isFull() {
        return ((front == 0 && rear == size - 1) || (front == rear + 1));
    }


    //  1  2 3 4

    public boolean isEmpty() {
        return front == -1;
    }

    public void queue(T data) {
        if (!isFull()) {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = data;
        } else {
            System.out.println("Queue is full");
        }


    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        T data = (T) queue[(front)];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return (T) queue[front];
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % size) {
                System.out.println(queue[i]);
            }
            System.out.println(queue[rear]);
        }
    }

    public int getSize() {
        return Math.abs(rear - front + 1);
    }

    enum Operation {
        QUEUE(0),
        DEQUEUE(1),
        PEEK(2),
        DISPLAY(3),
        EXIT(4);
        private final int value;

        Operation(int val) {
            this.value = val;
        }
    }
}
