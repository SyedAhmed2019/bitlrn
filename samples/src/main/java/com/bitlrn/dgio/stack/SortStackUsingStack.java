package com.bitlrn.dgio.stack;
// 5 -3 4 -2 1  //
// 5 -3 4 -2    // 1
// 5 -3 4      // -2
// 5 -3       //
//         //-3 -2 1 4 5

/**
 * Given a stack, sort it using only stack operations (push and pop). You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The
 * values in the stack are to be sorted in ascending order, with the smallest elements on top.
 */
public class SortStackUsingStack {
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<>(20);
        while (!input.isEmpty()) {
            int current = input.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > current) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(current);
        }
        while (!tmpStack.isEmpty()) {
            input.push(tmpStack.pop());
        }
        return input;
    }

    // [-13,13,-12,12,-11,11,-10,10,]

    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>(20);
        inputStack.push(-13);
        inputStack.push(13);
        inputStack.push(-12);
        inputStack.push(12);
        inputStack.push(-11);
        inputStack.push(11);
        inputStack.push(-10);
        inputStack.push(10);
        inputStack.display();
        Stack<Integer> sortedStack = sortStack(inputStack);
        sortedStack.display();
        System.out.println(sortedStack.peek());

    }
}
