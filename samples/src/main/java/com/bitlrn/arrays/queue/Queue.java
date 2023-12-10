package com.bitlrn.arrays.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * FIFO type queue
 */
public class Queue<T> {
    private final List<T> items;
    private int head;


    public Queue() {
        items = new ArrayList<>();
        head = 0;
    }

    public void enqueue(T item){
        items.add(item);
    }

    public T dequeue(){
        return items.remove(head++);
    }
}
