package com.bitlrn.tree.bst;

import com.bitlrn.tree.basic.Tree;

public class TargetFinder<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        TargetFinder<Integer> tf = new TargetFinder<>();
        tf.prepareTest(args);
        System.out.println(tf.findTarget(tf.root, 8));
        System.out.println(tf.findTarget(tf.root, 9));
    }

    private boolean findTarget(TreeNode<Integer> root, int target) {
        if (root != null) {
            if (root.data.compareTo(target) == 0) {
                return true;
            }
            if (root.data.compareTo(target) < 0) {
                return findTarget(root.right, target);
            }
            if (root.data.compareTo(target) > 0) {
                return findTarget(root.left, target);
            }
        }
        return false;
    }

}
