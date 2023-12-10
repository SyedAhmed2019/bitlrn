package com.bitlrn.dgio.linkedlists;

public class Node<T extends Comparable<T>> {
    final public T data;
    public Node<T> next;


    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}


