package com.bitlrn.dgio.queue;

/**
 * Your task is to implement a stack using two queues. The stack should support standard operations like
 * push (add an element to the top of the stack) and pop (remove an element from the top of the stack).
 */
public class QueueBasedStack {
    CircularQueue<Integer> queuePush = new CircularQueue<>(10);
    CircularQueue<Integer> queuePop = new CircularQueue<>(10);

    public static void main(String[] args) {
        QueueBasedStack qbs = new QueueBasedStack();
        for (int i : new int[]{1, 2, 3}) {
            qbs.push(i);
        }
        qbs.display();
        qbs.pop();
        qbs.display();
        qbs.pop();

        qbs.pop();
        qbs.display();
        // empty here

        System.out.println("second test");
        // insert  [9, 8, 7, 6, 5, 4]
        for (int i : new int[]{9, 8, 7, 6, 5, 4}) {
            qbs.push(i);
        }
        qbs.display();
        qbs.pop();
        qbs.display();
        qbs.pop();
        qbs.pop();
        qbs.display();
        // insert 1, 2
        for (int i : new int[]{1, 2}) {
            qbs.push(i);
        }
        System.out.println("last test");
        qbs.display();
        qbs.pop();
        qbs.display();
    }

    public void pushLittleInvolved(int x) {
        if (queuePush.isEmpty() && queuePop.isEmpty()) {
            queuePush.queue(x);
            return;
        }
        // ToDo: Write Your Code Here.
        if (!queuePush.isEmpty()) {
            if (queuePop.isEmpty()) {
                queuePop.queue(x);
            }
            while (!queuePush.isEmpty()) {
                queuePop.queue(queuePush.dequeue());
            }
        } else {

            if (!queuePop.isEmpty()) {
                if (queuePush.isEmpty()) {
                    queuePush.queue(x);
                }
                while (!queuePop.isEmpty()) {
                    queuePush.queue(queuePop.dequeue());
                }
            }
        }

    }

    public int popLittleInvolved() {
        if (!queuePush.isEmpty()) {
            return queuePush.dequeue();
        } else if (!queuePop.isEmpty()) {
            return queuePop.dequeue();
        }
        return -1;
    }

    public void push(int x) {
        queuePop.queue(x);
        while (!queuePush.isEmpty()) {
            queuePop.queue(queuePush.dequeue());
        }
        //swap the queue
        CircularQueue<Integer> temp = queuePush;
        queuePush = queuePop;
        queuePop = temp;

    }

    public int pop() {
        return queuePush.dequeue();
    }

    public void display() {
        if (!queuePush.isEmpty()) {
            queuePush.display();
        } else {
            System.out.println("push queue is empty");
        }
    }
}
