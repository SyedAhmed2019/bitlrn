package com.bitlrn.tree.basic;

import java.util.List;

public class Tree<T extends Comparable<T>> {
    public TreeNode<T> root;

    public void prepareTest(String[] args) {
        List<Integer> input1 = List.of(3, 4, 5, 1, 2);
        List<Integer> input = List.of(5, 4, 3, 8, 6);
        for (Integer current : input) {
            this.root = this.createTree(this.root, (T) current);
        }
        TreeNode<T> current = this.root;
        System.out.println("================IN ORDER ================");
        displayTree(current, Mode.INOREDER);
        System.out.println("================POST ORDER ================");
        displayTree(current, Mode.POSTORDER);
        System.out.println("================PRE ORDER ================");
        displayTree(current, Mode.PREORDER);

    }

    public void prepareTestString(String[] args) {
        List<String> input = List.of("/", "foo", "Baz", "Bar");
        for (String current : input) {
            this.root = this.createTree(this.root, (T) current);
        }
        TreeNode<T> current = this.root;
        System.out.println("================IN ORDER ================");
        displayTree(current, Mode.INOREDER);
        System.out.println("================POST ORDER ================");
        displayTree(current, Mode.POSTORDER);
        System.out.println("================PRE ORDER ================");
        displayTree(current, Mode.PREORDER);

    }

    public TreeNode<T> createTree(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<>(data);
        } else if (data.compareTo(root.data) < 0) {
            root.left = createTree(root.left, data);
        } else {
            root.right = createTree(root.right, data);
        }
        return root;
    }

    public void displayTree(TreeNode<T> root, Mode mode) {
        if (Mode.INOREDER == mode) {
            displayInorderTree(root);
        } else if (Mode.PREORDER == mode) {
            displayPreorderTree(root);
        } else {
            displayPostOrderTree(root);
        }
    }

    public void displayPostOrderTree(TreeNode<T> root) {
        if (root == null) {
        } else {
            displayPostOrderTree(root.right);
            System.out.println(root.data);
            displayPostOrderTree(root.left);
        }
    }

    public void displayPreorderTree(TreeNode<T> root) {
        if (root == null) {
        } else {
            System.out.println(root.data);
            displayPreorderTree(root.left);
            displayPreorderTree(root.right);
        }
    }

    public void displayInorderTree(TreeNode<T> root) {
        if (root == null) {
        } else {
            displayInorderTree(root.left);
            System.out.println(root.data);
            displayInorderTree(root.right);
        }
    }

    protected TreeNode<T> createNonBstTree(TreeNode<T> root, T val, boolean left) {
        if (root != null) {
            if (left) {
                root.left = createNonBstTree(root.left, val, !left);
            } else {
                root.right = createNonBstTree(root.right, val, !left);
            }
        } else {
            root = new TreeNode<>(val);
        }

        return root;
    }

    protected <T extends Comparable<T>> TreeNode<T> findNode(TreeNode<T> root, T val) {
        if (root != null) {
            if (root.data.compareTo(val) == 0) {
                return root;
            }
            TreeNode<T> left = findNode(root.left, val);
            if (left == null) {
                return findNode(root.right, val);
            } else {
                return left;
            }
        } else {
            return null;
        }

    }

    protected static class TreeNode<T> {
        public final T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public int level;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.level = -1;
        }
    }
}
