package com.bitlrn.bfs;

import com.bitlrn.tree.basic.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Visible nodes which are the right most node needs to be displayed.
 */
public class RightSideVisibleNodes<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        RightSideVisibleNodes<Integer> rsvn = new RightSideVisibleNodes<>();
        rsvn.prepareTest(args);
        List<Integer> results = rsvn.listRightSideVisibleNodes(rsvn.root);
        results.stream().forEach(System.out::println);


    }

    private List<T> listRightSideVisibleNodes(TreeNode<T> root) {
        List<T> results = new ArrayList<>();
        Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            results.add(queue.peek().data);
            for (int i = 0; i < n; ++i) {
                TreeNode<T> current = queue.pop();
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
            }
        }
        return results;
    }

}
