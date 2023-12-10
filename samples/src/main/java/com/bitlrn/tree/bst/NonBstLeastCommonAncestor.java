package com.bitlrn.tree.bst;

import com.bitlrn.tree.basic.Tree;

public class NonBstLeastCommonAncestor<T extends Comparable<T>> extends Tree<T> {

    public static void main(String[] args) {
        NonBstLeastCommonAncestor<Integer> tree = new NonBstLeastCommonAncestor<>();
        TreeNode<Integer> root = null;
        for (int i = 8; i >= 0; --i) {
            root = tree.createNonBstTree(root, i, true);
        }
        tree.displayPreorderTree(root);
        TreeNode<Integer> node1 = tree.findNode(root, 4);
        System.out.println("node1:" + node1.data);
        TreeNode<Integer> node2 = tree.findNode(root, 0);
        System.out.println("node2:" + node2.data);
        System.out.println(tree.lca(root, node1, node2).data);
    }

    private TreeNode<T> lca(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2) {
        if (root != null) {
            if (node1.data.compareTo(root.data) == 0 || node2.data.compareTo(root.data) == 0) {
                return root;
            }
            TreeNode<T> left = lca(root.left, node1, node2);
            TreeNode<T> right = lca(root.right, node1, node2);
            if (left != null && right != null) {
                return left;
            } else if (left == null) {
                return right;
            } else {
                return left;
            }
        } else {
            return null;
        }

    }

}
