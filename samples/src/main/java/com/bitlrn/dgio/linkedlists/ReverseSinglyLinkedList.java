package com.bitlrn.dgio.linkedlists;

import com.bitlrn.dgio.stack.Stack;

public class ReverseSinglyLinkedList<T extends Comparable<T>> {
    private final Stack<Node> stack = new Stack<>(10);

    public static void main(String[] args) {
        ReverseSinglyLinkedList<Integer> rll = new ReverseSinglyLinkedList<>();
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 0; i < 8; ++i) {
            sll.add(i);
        }
        sll.display();
        Node<Integer> head = rll.reverseList(sll.head());
        sll.head(head);
        sll.display();

    }

    public Node<T> reverseListMine(Node<T> head) {
        // TODO: Write your code here
        if (head == null) {
            return null;
        } else {
            Node<T> curr = head;
            while (curr != null) {
                stack.push(curr);
                curr = curr.next;
            }
            head = null;
            Node<T> prev = null;
            Node<T> item = null;
            while (!stack.isEmpty()) {
                item = stack.pop();
                if (head == null) {
                    head = item;
                    item.next = null;
                } else {
                    prev = head;
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                    prev.next = item;
                    item.next = null;
                }
            }

        }
        return head;
    }

    // 1 2 3 4 5 6
    // 1
    public Node<T> reverseList(Node<T> head) {
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
