package com.bitlrn.tree.bst;

import com.bitlrn.tree.basic.Tree;

import java.util.ArrayList;
import java.util.List;


public class LowestCommonAncestor<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        LowestCommonAncestor<Integer> lca = new LowestCommonAncestor<>();
        lca.prepareTest(args);
        testLcaNonOptimal(lca);
        System.out.println(lca.lcaOptimal(lca.root, 3, 8));
        //System.out.print(lcaValue);
    }

    private static void testLcaNonOptimal(LowestCommonAncestor<Integer> lca) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        if (lca.lowestCommonAncestorNonOptimal(lca.root, 3, left)) {
            if (lca.lowestCommonAncestorNonOptimal(lca.root, 8, right)) {
                if (left.size() < right.size()) {
                    System.out.println(left.get(left.size() - 1));
                } else if (right.size() < left.size()) {
                    System.out.println(right.get(right.size() - 1));
                } else {
                    int n = left.size() - 1;
                    while (!left.get(n).equals(right.get(n))) {
                        n--;
                    }
                    System.out.println(left.get(n));
                }
            }
        }
    }

    private T lcaOptimal(TreeNode<T> root, T first, T second) {
        if (root != null) {
            if (first.compareTo(root.data) < 0 && second.compareTo(root.data) < 0) {
                return lcaOptimal(root.left, first, second);
            } else if (first.compareTo(root.data) > 0 && second.compareTo(root.data) > 0) {
                return lcaOptimal(root.right, first, second);
            } else {
                return root.data;
            }
        }
        return null;

    }

    private boolean lowestCommonAncestorNonOptimal(TreeNode<T> root, T value, List<T> ancestors) {
        if (root != null) {
            if (value.compareTo(root.data) == 0) {
                ancestors.add(root.data);
                return true;
            } else if (value.compareTo(root.data) < 0) {
                ancestors.add(root.data);
                return lowestCommonAncestorNonOptimal(root.left, value, ancestors);
            } else {
                ancestors.add(root.data);
                return lowestCommonAncestorNonOptimal(root.right, value, ancestors);
            }
        } else {
            return false;
        }
    }
}
