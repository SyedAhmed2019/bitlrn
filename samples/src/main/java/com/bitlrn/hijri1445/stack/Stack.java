package com.bitlrn.hijri1445.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stack {
    private final List<Integer> stack;
    private int index;

    public Stack() {
        stack = new ArrayList<>();
        index = -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack myStack = new Stack();

        while (true) {
            System.out.println("Select operation to perform\n 0. Exit (enter 0) \n 1. Push(enter 1)\n 2. Pop (enter 2)\n 3. Peek (enter 3) ");
            int input = scanner.nextInt();
            Operation operation = Operation.values()[input];
            int value = 0;
            switch (operation) {
                case EXIT:
                    System.out.println("Goodbye!");
                    return;
                case PUSH:
                    System.out.println("Enter the value to be pushed:");
                    value = scanner.nextInt();
                    myStack.push(value);
                    break;
                case POP:
                    System.out.println("Popped value is:" + myStack.pop());
                    break;
                case PEEK:
                    System.out.println("Peeked value is " + myStack.peek());
                    break;
            }
        }
    }

    public void push(int value) {
        stack.add(value);
        index = stack.indexOf(value);
    }

    public int pop() {
        if (index >= 0) {
            int value = stack.remove(index);
            index--;
            return value;
        } else {
            System.out.println("nothing to pop");
            return -1;
        }
    }

    public int peek() {
        if (index >= 0) {
            return stack.get(index);
        } else {
            System.out.println("nothing to peek");
            return -1;
        }
    }


    enum Operation {
        EXIT,
        PUSH,
        POP,
        PEEK
    }
}
