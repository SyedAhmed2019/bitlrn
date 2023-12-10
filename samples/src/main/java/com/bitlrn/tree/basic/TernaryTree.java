package com.bitlrn.tree.basic;

import java.util.ArrayList;
import java.util.List;

public class TernaryTree<T extends Comparable<T>> {
    public TernaryTreeNode<T> root;

    public TernaryTreeNode<T> createTree(TernaryTreeNode<T> root, T data) {
        if (root == null) {
            root = new TernaryTreeNode<>(data);
        } else {
            TernaryTreeNode<T> child = new TernaryTreeNode<>(data);
            root.children.add(child);
        }
        return root;
    }

    public void displayTree(TernaryTreeNode<T> root) {
        System.out.println(root.data);
        for (TernaryTreeNode<T> child : root.children) {
            displayTree(child);
        }
    }

    public static class TernaryTreeNode<T> {
        public final T data;
        public List<TernaryTreeNode<T>> children;

        public TernaryTreeNode(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
}
