package com.bitlrn.tree.basic;

public class TreeFindMaxValueNode<T extends Comparable<T>> extends Tree<T> {

    public static void main(String[] args) {
        TreeFindMaxValueNode<Integer> maxValueTree = new TreeFindMaxValueNode<>();
        int value = 5;
        maxValueTree.prepareTest(args);
        Integer maxValue = maxValueTree.findMaxValueNode(maxValueTree.root, 0);
        if (maxValue != null) {
            System.out.println(maxValue);
        }
    }

    private T findMaxValueNode(TreeNode<T> root, T maxValue) {
        if (root != null) {
            if (root.data.compareTo(maxValue) >= 0) {
                maxValue = root.data;
            }
            T lhsMax = findMaxValueNode(root.left, maxValue);
            T rhsMax = findMaxValueNode(root.right, maxValue);
            if (lhsMax != null && rhsMax != null) {
                return (lhsMax.compareTo(rhsMax) >= 0 ? lhsMax : rhsMax);
            } else if (lhsMax == null) {
                return rhsMax;
            } else {
                return lhsMax;
            }
        }
        return maxValue;
    }
}
