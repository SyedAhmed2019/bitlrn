package com.bitlrn.tree.basic;

public class InvertTree<T extends Comparable<T>> extends Tree<T> {

    public static void main(String[] args) {
        InvertTree<Integer> invertTree = new InvertTree<>();
        invertTree.prepareTest(args);
        TreeNode<Integer> newTree = invertTree.createInvertTree(invertTree.root);
        invertTree.displayTree(newTree, Mode.PREORDER);

    }

    private TreeNode<T> createInvertTree(TreeNode<T> root) {
        if (root != null) {
            TreeNode<T> newTree = new TreeNode<>(root.data);
            newTree.right = createInvertTree(root.left);
            newTree.left = createInvertTree(root.right);
            return newTree;
        } else {
            return null;
        }
    }
}
