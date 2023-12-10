package com.bitlrn.dgio.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next Greater Element for an element x is the first greater element
 * on the right side of x in the array.
 * Elements for which no greater element exist, consider the next greater element as -1.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 5, 2, 25]
 * Output: [5, 25, 25, -1]
 * 2,4,5,25  -log
 * <p>
 * <p>
 * Input: [13, 7, 6, 12]
 * Output: [-1, 12, 12, -1]
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4, 5]
 * Output: [2, 3, 4, 5, -1]
 */
public class NextGreaterGenerator {
    public static void main(String[] args) {
        NextGreaterGenerator gen = new NextGreaterGenerator();
        System.out.println(gen.nextLargerElementBruteForce(List.of(4, -5, -3, 5, 6, 7)));
        System.out.println(gen.nextLargerElement(List.of(4, -5, -3, 5, 6, 7)));
    }

    public List<Integer> nextLargerElementBruteForce(List<Integer> arr) {
        List<Integer> res = new ArrayList<>();

        Integer[] input = arr.toArray(new Integer[0]);

        for (int i = 0; i < input.length; ++i) {
            int nextMax = Integer.MAX_VALUE;
            for (int j = i + 1; j < input.length; ++j) {
                if (arr.get(j) > arr.get(i)) {
                    if (arr.get(j) < nextMax) {
                        nextMax = arr.get(j);
                    }
                }
            }
            if (nextMax != Integer.MAX_VALUE) {
                res.add(i, nextMax);
            } else {
                res.add(i, -1);
            }
        }
        return res;
    }

    // 2 1 4 3
    // push 3
    // 4 > 3 pop 3 push 4 have -1
    // 2 1 4 -1
    // 2 1 -1 -1
    // 2 4 -1 -1
    // 4 4 -1 -1
    public List<Integer> nextLargerElement(List<Integer> arr) {
        Stack<Integer> stack = new Stack<>(arr.size());
        Integer[] input = arr.toArray(new Integer[0]);
        Integer[] res = new Integer[input.length];
        int high = input.length - 1;
        for (int i = high; i >= 0; i--) {
            while (!stack.isEmpty() && input[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(input[i]);
        }
        return List.of(res);
    }
}
