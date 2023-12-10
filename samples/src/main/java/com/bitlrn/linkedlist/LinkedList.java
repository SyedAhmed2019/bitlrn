package com.bitlrn.linkedlist;

import java.util.Scanner;

public class LinkedList {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node head = linkedList.create();
        linkedList.display(head);
    }

    public Node create() {
        Node head = null;
        while (scanner.nextInt() != -1) {
            System.out.println("enter node info:");
            Node node = new Node();
            node.info = scanner.nextInt();
            node.next = null;
            if (head == null) {
                head = node;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }
        return head;
    }

    public void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
        }
        System.out.println();
    }

    class Node<T> {
        T info;
        Node next;
    }
}
