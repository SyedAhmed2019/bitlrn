package com.bitlrn.dgio.linkedlists;

public class DlNode<T extends Comparable<T>> {
    final T data;
    DlNode<T> next;
    DlNode<T> prev;

    public DlNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
