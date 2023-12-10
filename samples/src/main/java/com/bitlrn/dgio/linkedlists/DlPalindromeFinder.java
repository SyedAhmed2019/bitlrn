package com.bitlrn.dgio.linkedlists;

/**
 * Given a doubly linked list, the task is to determine whether it is a palindrome. A doubly linked list is a palindrome if it reads
 * the same backward as forward, utilizing the previous and next pointers of the nodes.
 */
public class DlPalindromeFinder {

    public static void main(String[] args) {
        DlPalindromeFinder dlPalindromeFinder =
                new DlPalindromeFinder();
        DoublyLinkedList<Character> dll = new DoublyLinkedList<>();
        for (char c : "racecar".toCharArray()) {
            dll.insert(c);
        }
        System.out.println("is palindrome racecar" + dlPalindromeFinder.isPalindrome(dll.head()));

        dll = new DoublyLinkedList<>();
        for (char c : "racecars".toCharArray()) {
            dll.insert(c);
        }
        System.out.println("is palindrome racecars" + dlPalindromeFinder.isPalindrome(dll.head()));

    }

    public boolean isPalindrome(DlNode<Character> head) {
        // ToDo: Write your code here.
        // 1. have two temp pointer one starting from front and one rear
        // 2. till the pointers cross each other step once in opposite direction
        //    comparing the data
        // 3. all the characters should match till the pointers cross to consider palindrome
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        DlNode<Character> front = head;
        DlNode<Character> rear = head;
        while (rear.next != null) {
            rear = rear.next;
        }
        while (front != null & rear != null) {
            if (front.data.compareTo(rear.data) == 0) {
                front = front.next;
                rear = rear.prev;
            } else {
                return false;
            }
        }
        return true;
    }
}
