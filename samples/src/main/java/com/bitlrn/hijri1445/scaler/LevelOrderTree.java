package com.bitlrn.hijri1445.scaler;


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LevelOrderTree {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 4, 5, 6, 7};
        LevelOrderTree lot = new LevelOrderTree();
        TreeNode node = lot.buildTree(input, 0);
        lot.printInorder(node);
        System.out.println("preorder");
        lot.printPreorder(node);
        System.out.println("postorder");
        lot.printPostorder(node);
    }

    public TreeNode buildTree(int[] values, int i) {
        TreeNode root = null;
        if (i < values.length) {
            root = new TreeNode(values[i]);
            root.left = buildTree(values, 2 * i + 1);
            root.right = buildTree(values, 2 * i + 2);
        }
        return root;
    }

    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.val);
            printInorder(root.right);
        }
    }

    public void printPreorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public void printPostorder(TreeNode root) {
        if (root != null) {
            printPostorder(root.right);
            System.out.println(root.val);
            printPostorder(root.left);
        }
    }

}
