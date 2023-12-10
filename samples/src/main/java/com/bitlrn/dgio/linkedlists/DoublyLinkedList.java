package com.bitlrn.dgio.linkedlists;

public class DoublyLinkedList<T extends Comparable<T>> {

    private DlNode<T> front;
    private DlNode<T> rear;

    public DoublyLinkedList() {
        front = null;
        rear = null;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            dll.insert(i);
        }
        dll.display();
        dll.insert(11);
        dll.display();
        dll.insert(10);
        dll.display();
        dll.remove(5);
        dll.display();
        dll.insertAfter(6, 12);
        dll.display();
        dll.displayFromBack();

    }

    public void insert(T data) {
        DlNode<T> newNode = new DlNode<>(data);
        DlNode<T> current = front;
        while (current != null && current.next != null) {
            current = current.next;
        }
        if (current == null) {
            current = newNode;
            front = current;
            rear = current;
        } else {
            current.next = newNode;
            newNode.prev = current;
            rear = newNode;
        }
    }

    public void remove(T data) {
        DlNode<T> current = front;
        while (current != null) {
            if (current.data == data) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                break;
            } else {
                current = current.next;
            }
        }
    }

    public DlNode<T> find(T data) {
        DlNode<T> current = front;
        while (current != null) {
            if (current.data == data) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public void insertAfter(T after, T data) {
        DlNode<T> found = find(after);
        if (found != null) {
            DlNode<T> newOne = new DlNode<>(data);
            newOne.next = found.next;
            newOne.prev = found;
            found.next.prev = newOne;
            found.next = newOne;
        } else {
            insert(data);
        }
    }

    public void display() {
        DlNode<T> current = front;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println(" ");
    }

    public void displayFromBack() {
        DlNode<T> current = rear;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.prev;
        }
        System.out.println(" ");
    }

    public DlNode<T> head() {
        return front;
    }
}
