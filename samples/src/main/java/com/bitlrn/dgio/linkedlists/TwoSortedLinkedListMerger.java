package com.bitlrn.dgio.linkedlists;

public class TwoSortedLinkedListMerger<T extends Comparable<T>> {
    // Function to merge two sorted linked lists

    // 0 2 4
    // 1 3

    public static void main(String[] args) {
        SinglyLinkedList<Integer> sl1 = new SinglyLinkedList<>();
        for (int i = 0; i <= 5; i++) {
            if (i % 2 == 0) {
                sl1.add(i);
            }
        }
        sl1.display();
        SinglyLinkedList<Integer> sl2 = new SinglyLinkedList<>();
        for (int i = 6; i <= 12; i++) {
            if (i % 2 != 0) {
                sl2.add(i);
            }
        }
        sl2.display();
        TwoSortedLinkedListMerger<Integer> tsll = new TwoSortedLinkedListMerger<>();
        Node<Integer> head = tsll.mergeTwoLists(sl1.head(), sl2.head());
        sl1.head(head);
        sl1.display();
    }

    public Node<Integer> mergeTwoListsInitial(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> c1 = l1;
        Node<Integer> c2 = l2;
        Node<Integer> c3 = null;
        Node<Integer> returnHead = new Node<>(-1);
        returnHead.next = c3;
        while (c1 != null && c2 != null) {
            if (c1.data.compareTo(c2.data) <= 0) {
                if (c3 == null) {
                    c3 = c1;
                    returnHead.next = c1;
                    c1 = c1.next;
                } else {
                    c3.next = c1;
                    c3 = c3.next;
                    c1 = c1.next;
                }
            } else {
                if (c3 == null) {
                    c3 = c2;
                    returnHead.next = c2;
                    c2 = c2.next;
                } else {
                    c3.next = c2;
                    c3 = c3.next;
                    c2 = c2.next;
                }
            }
        }
        if (c1 != null) {
            c3.next = c1;
        }

        if (c2 != null) {
            c3.next = c2;
        }

        return returnHead.next;
    }

    public Node<Integer> mergeTwoLists(Node<Integer> l1, Node<Integer> l2) {
        // Initialize a dummy node and a current pointer
        Node<Integer> dummy = new Node(-1);
        Node<Integer> current = dummy;

        // Traverse through both lists until one is exhausted
        while (l1 != null && l2 != null) {
            // Compare nodes and append the smaller one to current
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from the non-empty list
        if (l1 != null) current.next = l1;
        else current.next = l2;

        // Return the merged sorted list
        return dummy.next;
    }
}
