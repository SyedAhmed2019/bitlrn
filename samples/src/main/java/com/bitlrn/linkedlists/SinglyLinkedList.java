package com.bitlrn.linkedlists;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        // 1. insert into linked list at head
        //testInsertAtHead(singlyLinkedList);

        // 2. insert into linked list at end
        testInsertAtEnd(singlyLinkedList);

        // 3. search an element
        //testSearchNode(singlyLinkedList);

        // 4. insert after node
        testInsertAfterNode(singlyLinkedList);

        // 5. delete node
        testDeleteNode(singlyLinkedList);

        // 6. reverse
        testReverse(singlyLinkedList);

        //7. merge two lists
        singlyLinkedList.testMergeLists();


    }

    private static void testReverse(SinglyLinkedList singlyLinkedList) {
        singlyLinkedList.print();
        singlyLinkedList.reverse();
        singlyLinkedList.print();
    }

    private static void testDeleteNode(SinglyLinkedList singlyLinkedList) {
        // current state
        singlyLinkedList.print();
        System.out.println("Deleting node 6 resulted in " + singlyLinkedList.delete(6));
        singlyLinkedList.print();
        System.out.println("Deleting node 7 resulted in " + singlyLinkedList.delete(7));
        singlyLinkedList.print();
        System.out.println("Deleting non existed node 4 resulted in " + singlyLinkedList.delete(4));
    }

    private static void testInsertAfterNode(SinglyLinkedList singlyLinkedList) {
        singlyLinkedList.insertAfter(9, 7);
        singlyLinkedList.print();
        singlyLinkedList.insertAfter(10, 6);
        singlyLinkedList.print();
        singlyLinkedList.insertAfter(8, 5);
        singlyLinkedList.print();
        // non-existent node with 4 data - no change
        singlyLinkedList.insertAfter(4, 3);
        singlyLinkedList.print();
    }

    private static void testSearchNode(SinglyLinkedList singlyLinkedList) {
        System.out.println(singlyLinkedList.searchNode(10));
        System.out.println(singlyLinkedList.searchNode(25));
    }
    // 1(current,prev=null,next=null)->2->3->4
    // 1->2(next)
    // null<-1( <-2(prev,) -->3(next,current)

    private static void testInsertAtEnd(SinglyLinkedList singlyLinkedList) {
        singlyLinkedList.insertAtEnd(10);
        singlyLinkedList.insertAtEnd(9);
        singlyLinkedList.insertAtEnd(8);
        singlyLinkedList.print();
    }

    private static void testInsertAtHead(SinglyLinkedList singlyLinkedList) {
        singlyLinkedList.insertAtHead(10);
        singlyLinkedList.insertAtHead(9);
        singlyLinkedList.insertAtHead(8);
        singlyLinkedList.print();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtEnd(T data) {
        Node node = new Node(data);
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public void insertAtHead(T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }

    public boolean searchNode(T data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return true;
            }
            temp = temp.next;
        }
        return false; //value not found
    }

    public void insertAfter(T existingNodeData, T newNodeData) {
        Node newNode = new Node(newNodeData);
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (existingNodeData == temp.data) {
                newNode.next = temp.next;
                temp.next = newNode;
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found) {
            size++;
        }
    }

    public void reverse() {
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public Node mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> head1 = list1;
        Node<Integer> head2 = list2;
        Node<Integer> head = null;
        Node<Integer> lookahead1 = list1;
        Node<Integer> lookahead2 = list2;
        Node<Integer> commonLookahead = null;
        Node<Integer> prevlist1 = list1;
        Node<Integer> prevlist2 = list2;
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else {
            while (lookahead1 != null && lookahead2 != null) {
                prevlist1 = lookahead1;
                prevlist2 = lookahead2;
                if (prevlist1.data < prevlist2.data) {
                    if (commonLookahead != null) {
                        commonLookahead.next = prevlist1;
                    } else {
                        head = head1;
                    }
                    commonLookahead = prevlist1;

                    lookahead1 = lookahead1.next;

                } else {
                    if (commonLookahead != null) {
                        commonLookahead.next = prevlist2;
                    } else {
                        head = head2;
                    }
                    commonLookahead = prevlist2;

                    lookahead2 = lookahead2.next;
                }
            }
            if (lookahead1 != null) {
                commonLookahead.next = prevlist1;
            } else if (lookahead2 != null) {
                commonLookahead.next = prevlist2;
            }
            return head;
        }

    }

    // a->b->c
    public boolean delete(T data) {
        boolean found = false;
        Node temp = head;
        Node prev = head;
        while (temp != null) {
            if (temp.data == data) {
                if (temp == head) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                    temp.next = null;
                    temp.data = null;
                }
                found = true;
                break;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return found;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            if (temp.next == null) {
                System.out.print("null");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private void testMergeLists() {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(4);

        list2.insertAtEnd(1);
        list2.insertAtEnd(3);
        list2.insertAtEnd(4);

        SinglyLinkedList<Integer>.Node<Integer> finalHead = list1.mergeTwoLists(list1.head, list2.head);
        while (finalHead != null) {
            System.out.print(finalHead.data + " ");
        }


    }

    public class Node<T> {
        private T data;
        private Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
