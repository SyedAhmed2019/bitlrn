package com.bitlrn.arrays.queue;

import java.util.LinkedList;

public class CircularQueue {
    private final int[] items;
    private int head;
    private int tail;

    private final int size;

    public CircularQueue(int size) {
        this.items = new int[size];
        head = -1;
        tail = -1;
        this.size = size;
    }

    public boolean enqueue(int val){
        if(isFull()){
            return false;
        }
        if (isEmpty()){
            head = 0;
        }
        items[(tail+1)%size] = val;
        return true;
    }

    public boolean dequeue(){
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head = -1;
            tail = -1;
        }else {
            head = (head + 1) % size;
        }
        return true;
    }

    public int front(){
        if(isEmpty()){
            return -1;
        }
        return items[head];
    }

    public int rear(){
        if(isEmpty()){
            return -1;
        }
        return items[tail];
    }

    private boolean isFull() {
        return (tail+1%size) == head;
    }

    private boolean isEmpty() {
        return head == -1;
    }

    public static void main(String[] args) {
        // test our circular queue
        CircularQueue queue = new CircularQueue(5);
        System.out.println("Is emtpy?"+queue.isEmpty());
        System.out.println("Is Full?"+queue.isFull());
        for (int i=0; i < 5;++i) {
            queue.enqueue(i);
        }
        System.out.println("Enqueue new element when full possible?"+queue.enqueue(6));
        System.out.println("Dequeue first element =1?"+queue.dequeue() );

        //Test operations on java built in queue
        java.util.Queue<Integer> javaQueue = new LinkedList<>();
        for (int i=0; i < 5;++i) {
            javaQueue.add(i);
        }
        System.out.println(javaQueue.peek());
        System.out.println(javaQueue.poll());

    }
}
