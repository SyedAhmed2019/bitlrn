package com.bitlrn.tree.basic;

public class TreeVisibleNodeCounter<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        TreeVisibleNodeCounter<Integer> visibleCountTree = new TreeVisibleNodeCounter<>();
        visibleCountTree.prepareTest(args);
        System.out.println(visibleCountTree.countVisibleNodes(visibleCountTree.root, Integer.MIN_VALUE));
    }

    //              5
    //          4       6
    //       3    2        7
    //

    private int countVisibleNodes(TreeNode<Integer> root, int max) {
        int totalCount = 0;
        if (root != null) {
            if (root.data >= max) {
                totalCount++;
                max = root.data;
            }
            totalCount += countVisibleNodes(root.left, max);
            totalCount += countVisibleNodes(root.right, max);
        }
        return totalCount;
    }


}
