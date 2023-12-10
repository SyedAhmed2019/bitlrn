package com.bitlrn.tree.basic;

import java.util.Objects;

public class DfsSearch<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        DfsSearch<Integer> dfs = new DfsSearch<>();
        dfs.prepareTest(args);
        int target = 4;
        System.out.println("searching " + target + "in tree using dfs");
        System.out.println(dfs.search(dfs.root, target));


    }

    private boolean search(TreeNode<Integer> root, Integer target) {
        if (root != null) {
            if (Objects.equals(root.data, target)) {
                return true;
            } else {
                boolean leftSearch = search(root.left, target);
                if (!leftSearch) {
                    return search(root.right, target);
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }
}
