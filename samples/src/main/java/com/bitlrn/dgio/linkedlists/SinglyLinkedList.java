package com.bitlrn.dgio.linkedlists;

public class SinglyLinkedList<T extends Comparable<T>> {
    public Node<T> head;

    public SinglyLinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            list.add(i);
        }
        list.display();
        System.out.println("find...");
        Node<Integer> result = list.find(3);
        if (result != null) {
            System.out.println(result.data);
        }
        list.remove(5);
        list.display();

        list.remove(2);
        list.display();
    }

    public Node<T> add(T data) {
        Node<T> newOne = new Node<>(data);
        Node<T> current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        if (current == null) {
            current = newOne;
            head = current;
        } else {
            current.next = newOne;
        }
        return current;
    }

    public Node<T> find(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Node<T> remove(T data) {
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            if (current.data == data) {
                break;
            }
            prev = current;
            current = current.next;
        }
        if (current == null) {
            return current;
        } else if (current != null) {
            if (prev == null) {
                head = null;
            } else {
                prev.next = current.next;
            }
            return current;
        }
        return null;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public Node<T> head() {
        return head;
    }

    public void head(Node<T> head) {
        this.head = head;
    }


}
