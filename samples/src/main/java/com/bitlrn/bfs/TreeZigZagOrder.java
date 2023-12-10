package com.bitlrn.bfs;

import com.bitlrn.tree.basic.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeZigZagOrder<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        TreeZigZagOrder<Integer> tzo = new TreeZigZagOrder<>();
        tzo.prepareTest(args);
        tzo.zigZagOrder(tzo.root).forEach(System.out::println);
    }

    private List<List<Integer>> zigZagOrder(TreeNode<Integer> root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode<Integer>> queue = new Stack<>();
            queue.push(root);
            List<TreeNode<Integer>> children = new ArrayList<>();
            boolean left = false;
            List<Integer> currentResult = new ArrayList<>();
            while (!queue.isEmpty()) {
                if (currentResult.isEmpty()) {
                    currentResult.addAll(queue.stream().map(e -> e.data).toList());
                    results.add(currentResult);
                }
                TreeNode<Integer> current = queue.pop();
                if (left) {
                    if (current.left != null) {
                        children.add(current.left);
                    }
                    if (current.right != null) {
                        children.add(current.right);
                    }
                } else {
                    if (current.right != null) {
                        children.add(current.right);
                    }
                    if (current.left != null) {
                        children.add(current.left);
                    }
                }
                if (queue.isEmpty()) {
                    queue.addAll(children);
                    currentResult = new ArrayList<>();
                    children = new ArrayList<>();
                    left = !left;
                }
            }
        }
        return results;
    }
}
