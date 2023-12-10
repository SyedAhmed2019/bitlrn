package com.bitlrn.bfs;

import com.bitlrn.tree.basic.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinDepthBinaryTree<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        MinDepthBinaryTree<Integer> mdbt = new MinDepthBinaryTree<>();
        mdbt.prepareTest(args);
        System.out.println(mdbt.minDepthTree(mdbt.root));

    }

    private int minDepthTree(TreeNode<T> root) {
        int depth = 0;
        if (root != null) {
            Deque<TreeNode<T>> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<T> current = queue.pop();
                if (current.right == null && current.left == null) {
                    return depth;
                } else {
                    if (queue.isEmpty()) {
                        depth++;
                    }
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
            }
        }

        return depth;
    }
}
