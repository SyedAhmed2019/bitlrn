package com.bitlrn.dgio.stack;

/**
 * Stack using list data structure
 */
public class StackList<T> {
    private Node<T> top;

    public StackList() {
        top = null;
    }

    public static void main(String[] args) {
        StackList sl = new StackList();
        sl.push(1);
        sl.push(2);
        sl.push(3);
        sl.display();
        sl.pop();
        sl.display();
        sl.pop();
        sl.display();
        System.out.println(sl.isEmpty());
        System.out.println(sl.peek());
        sl.display();
    }

    public void push(T data) {
        if (top == null) {
            top = new Node(data);
        } else {
            Node<T> current = new Node(data);
            current.next = top;
            top = current;
        }
    }

    public T pop() {
        if (top == null) {
            throw new IllegalStateException("stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (top == null) {
            throw new IllegalStateException("stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        System.out.println("From top of the stack:");
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
