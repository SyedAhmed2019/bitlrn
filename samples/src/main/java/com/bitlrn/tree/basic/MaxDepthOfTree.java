package com.bitlrn.tree.basic;


/**
 * Max depth of a binary tree is the longest root-to-leaf path. Given a binary tree, find its max depth. Here, we define the length of the path to be the number of edges on that path, not the number of nodes.
 */
public class MaxDepthOfTree<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        MaxDepthOfTree<Integer> mdt = new MaxDepthOfTree<>();
        mdt.prepareTest(args);
        int depth = mdt.findDepthOfTree(mdt.root, 0);
        System.out.println("Till leaf nodes:" + depth);
    }

    private int findDepthOfTree(TreeNode<T> root, int current) {
        if (root != null) {
            int lhs = findDepthOfTree(root.left, current + 1);
            int rhs = findDepthOfTree(root.right, current + 1);
            return Integer.max(lhs, rhs);
        }
        return current - 1;
    }
}
