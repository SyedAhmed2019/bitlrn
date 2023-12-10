package com.bitlrn.tree.basic;

/**
 * A binary tree is considered balanced if, for every node in the tree, the difference in the height (or depth) of its left and right subtrees is at most 1.
 * <p>
 * In other words, the depth of the two subtrees for every node in the tree differ by no more than one.
 * <p>
 * The height (or depth) of a tree is defined as the number of edges on the longest path from the root node to any leaf node.
 * <p>
 * Note: An empty tree is considered balanced by definition.
 * <p>
 * In that case, given a binary tree, determine if it's balanced.
 * <p>
 * Parameter
 * tree: A binary tree.
 * Result
 * A boolean representing whether the tree given is balanced.
 * 1
 * 2   3
 * 4 5
 * 6
 * The above is balanced
 * <p>
 * 1
 * 2   3
 * 4   5   6
 * 7
 * the above is not balanced
 */


public class TreeBinaryBalanced<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        TreeBinaryBalanced<Integer> tree = new TreeBinaryBalanced<>();
        tree.prepareTest(args);
        System.out.println((tree.isBalanced(tree.root) == 0));
    }

    private int isBalanced(TreeNode<T> root, int level) {
        if (root != null) {
            int leftLevel = isBalanced(root.left, level + 1);
            int rightLevel = isBalanced(root.right, level + 1);
            return (Math.abs(leftLevel - rightLevel) >= 0 || Math.abs(leftLevel - rightLevel) <= 1) ? level - 1 : -1;
        }
        return level - 1;
    }

    /**
     * root(5) count=0;
     * root(5) count =1;
     * root(4) count =1;
     * root(3) count =2; leftCnt =0;
     */

    private int isBalanced(TreeNode<T> root) {
        if (root != null) {
            int leftCnt = isBalanced(root.left);
            int rightCnt = isBalanced(root.right);
            if (leftCnt == -1 && rightCnt == -1) {
                return -1;
            }
            if (Math.abs(leftCnt - rightCnt) > 1) {
                return -1;
            } else {
                return Math.max(leftCnt, rightCnt) + 1;
            }
        } else {
            return -1;
        }

    }

}
