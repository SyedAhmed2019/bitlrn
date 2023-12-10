package com.bitlrn.tree.basic;

/**
 * Given a binary tree pretty print it e.g. folder structure.
 */
public class TreePrettyPrint<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        TreePrettyPrint<Integer> tree = new TreePrettyPrint<>();
        tree.prepareTest(args);
        tree.displayPrettyPrint(tree.root, 0);
        TreePrettyPrint<String> tree2 = new TreePrettyPrint<>();
        tree2.prepareTestString(args);
        tree2.displayPrettyPrint(tree2.root, 0);
    }

    private void displayPrettyPrint(TreeNode<T> root, int level) {
        if (root != null) {
            if (level > 0) {
                for (int i = 0; i < level; ++i) {
                    System.out.print(" ");
                }
                System.out.print("/");
            }
            System.out.println(root.data);

            displayPrettyPrint(root.left, level + 1);

            displayPrettyPrint(root.right, level + 1);
        }
    }
}
