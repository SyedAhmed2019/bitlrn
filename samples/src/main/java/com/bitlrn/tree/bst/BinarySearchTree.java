package com.bitlrn.tree.bst;

import com.bitlrn.tree.basic.Tree;

import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.prepareTest(args);
        int target = 6;
        System.out.println(isBst(bst.root));
        List<Integer> input2 = List.of(8, 3, 1, 6, 4, 10);
        TreeNode<Integer> root = null;
        for (int i = 0; i < input2.size(); ++i) {
            root = bst.createTree(root, input2.get(i));
        }
        System.out.println(isBst(root));


        System.out.println("Inserting two nodes....");
        // insert into bst tree
        // right side
        bst.insert(bst.root, 25);
        bst.displayPreorderTree(bst.root);
        // left side
        bst.insert(bst.root, 1);
        bst.displayPreorderTree(bst.root);
    }

    public static boolean isBst(TreeNode<Integer> root) {
        if (root != null) {
            if (root.left != null && root.left.data < root.data) {
                return isBst(root.left);
            } else if (root.left != null) {
                return false;
            }
            if (root.right != null && root.right.data > root.data) {
                return isBst(root.right);
            } else return root.right == null;
        }
        return true;
    }

    private TreeNode<T> insert(TreeNode<T> root, T t) {
        if (root != null) {
            if (t.compareTo(root.data) < 0) {
                root.left = insert(root.left, t);
            } else if (t.compareTo(root.data) >= 0) {
                root.right = insert(root.right, t);
            }
        } else {
            root = new TreeNode<>(t);
        }

        return root;
    }


}
