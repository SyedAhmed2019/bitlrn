package com.bitlrn.tree.bst;

import com.bitlrn.tree.basic.Tree;

public class BstValidator<T extends Comparable<T>> extends Tree<T> {

    public static void main(String[] args) {
        BstValidator<Integer> bstValidator = new BstValidator<>();
        bstValidator.prepareTest(args);
        System.out.println(bstValidator.isBstValid(bstValidator.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private boolean isBstValid(TreeNode<Integer> root, int min, int max) {
        if (root != null) {
            if (!(min < root.data && root.data < max)) {
                return false;
            }
            return isBstValid(root.left, min, root.data) && isBstValid(root.right, root.data, max);
        } else {
            return true;
        }
    }
}
