package com.bitlrn.dgio.linkedlists;

/**
 * Given a sorted linked list, your task is to modify it by removing all the duplicate elements to leave only distinct
 * numbers. The linked list should remain sorted, and the modified list should be returned.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates remover = new RemoveDuplicates();
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 0; i < 8; ++i) {
            sll.add(i);
            if (i % 2 == 0) {
                sll.add(i);
                sll.add(i);
            }
        }
        sll.display();
        sll.head(remover.deleteDuplicates(sll.head()));
        sll.display();

        sll = new SinglyLinkedList<>();
        for (int i = 0; i < 4; i++) {
            sll.add(i);
        }
        sll.display();
        sll.head(remover.deleteDuplicates(sll.head()));
        sll.display();

    }

    // 1 -> 2 ->2 -> 2 -> 3
    public Node<Integer> deleteDuplicates(Node<Integer> head) {
        Node<Integer> current = head;
        Node<Integer> prev;
        while (current != null) {
            prev = current;
            current = current.next;
            while (current != null && prev.data.equals(current.data)) {
                current = current.next;
                prev.next = current;

            }

        }
        // TODO: Write your code here
        return head;
    }
}
