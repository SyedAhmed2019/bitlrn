package com.bitlrn.dgio.stack;

/**
 * Stack using array.
 *
 * @param <T>
 */
public class Stack<T> {
    private final Object[] stack;
    private int top;

    public Stack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.display();
    }

    public void push(T item) {
        if (top == stack.length - 1) {
            throw new IndexOutOfBoundsException("Stack is full");
        }
        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("stack is empty - pop failed");
        }
        T result = (T) stack[top];
        stack[top] = null;
        top--;
        return result;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("stack is empty - peek failed");
        }
        return (T) stack[top];
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i <= top; ++i) {
            System.out.print(stack[i] + ",");
        }
        System.out.println("]");
    }
}
