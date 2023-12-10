package com.bitlrn.bfs;

import com.bitlrn.tree.basic.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * print tree in level order
 * Tree is build as
 * 0
 * 6       9
 * 5   7    8  10
 * <p>
 * Results should be
 * [0]
 * [6,9]
 * [5,7, 8, 10]
 */
public class TreeLevelOrder<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        TreeLevelOrder<Integer> treeLevelOrder = new TreeLevelOrder<>();
        treeLevelOrder.prepareTest(args);
        List<List<Integer>> results = treeLevelOrder.levelNodes(treeLevelOrder.root);
        results.forEach(System.out::println);
    }

    private List<List<Integer>> levelNodes(TreeNode<Integer> root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root != null) {
            Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
            queue.push(root);
            List<Integer> currentResult = new ArrayList<>();
            List<TreeNode<Integer>> children = new ArrayList<>();
            while (!queue.isEmpty()) {
                if (currentResult.isEmpty()) {
                    currentResult.addAll(queue.stream().map(e -> e.data).toList());
                    results.add(new ArrayList<>(currentResult));
                }

                TreeNode<Integer> current = queue.pop();
                if (current.left != null) {
                    children.add(current.left);
                    //levelResult.add(current.left.data
                }
                if (current.right != null) {
                    children.add(current.right);
                    //levelResult.add(current.right.data);
                }
                if (queue.isEmpty()) {
                    queue.addAll(new ArrayList<>(children));
                    currentResult = new ArrayList<>();
                    children.clear();

                }
            }
        }
        return results;
    }
}
