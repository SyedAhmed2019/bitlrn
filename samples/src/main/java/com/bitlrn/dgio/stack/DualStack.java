package com.bitlrn.dgio.stack;

/**
 * Your task is to implement two stacks in a single array efficiently.
 * You need to provide the following methods for the stacks: push1, push2, pop1, pop2.
 */
public class DualStack {
    public static void main(String[] args) {
        StackDual<Integer> stack = new StackDual<>(10);
        stack.push1(1);
        stack.push1(2);
        stack.push1(3);
        stack.display1();
        stack.push2(4);
        stack.push2(5);
        stack.display2();
        stack.pop1();
        stack.display1();
        stack.pop2();
        stack.display2();
    }

    static class StackDual<T> {
        private final Object[] stack;
        private int top1;
        private int top2;

        public StackDual(int size) {
            this.stack = new Object[size];
            top1 = -1;
            top2 = stack.length;
        }

        public void push1(T data) {
            if (top1 == stack.length || top1 == top2) {
                throw new IllegalStateException("Stack is full");
            }
            stack[++top1] = data;
        }

        public void push2(T data) {
            if (top2 == 0 || top1 == top2) {
                throw new IllegalStateException("Stack is full");
            }

            stack[--top2] = data;
        }

        public T pop1() {
            if (top1 == -1) {
                throw new IllegalStateException("stack is empty");
            }
            return (T) stack[top1--];
        }

        public T pop2() {
            if (top2 == -1) {
                throw new IllegalStateException("stack is empty");
            }
            T data = (T) stack[top2++];

            return data;
        }

        public void display1() {
            System.out.println("first stack:");
            for (int i = 0; i <= top1; ++i) {
                System.out.println(stack[i]);
            }
        }

        public void display2() {
            System.out.println("second stack:");
            for (int i = stack.length - 1; i >= top2; i--) {
                System.out.println(stack[i]);
            }
        }
    }

}
