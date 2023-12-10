package com.bitlrn.backtracking;

import com.bitlrn.tree.basic.TernaryTree;
import com.bitlrn.tree.basic.TernaryTreeChildType;

import java.util.ArrayList;
import java.util.List;

public class TernaryTreePathFinder<T extends Comparable<T>> extends TernaryTree<T> {
    public static void main(String[] args) {
        TernaryTreePathFinder<Integer> ttpf = new TernaryTreePathFinder<>();
        TernaryTreeNode<Integer> root = null;
        TernaryTreeNode<Integer> current = null;
        TernaryTreeChildType type;
        for (int i = 1; i <= 9; ++i) {
            if (i % 3 != 0) {
                root = ttpf.createTree(root, i);
                if (current == null) {
                    current = root;
                }
            } else {
                root = ttpf.createTree(root.children.get(i / 3 - 1), i);
            }
        }
        System.out.println("display");
        ttpf.displayTree(current);
        List<Integer> currentPath = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        ttpf.findAllPaths(current, currentPath, paths);
        paths.forEach(System.out::println);
    }

    private void findAllPaths(TernaryTreeNode<T> root, List<T> currentPath, List<String> paths) {
        if (root != null) {
            currentPath.add(root.data);
            for (TernaryTreeNode<T> child : root.children) {
                findAllPaths(child, currentPath, paths);
            }
            if (root.children.isEmpty()) {
                paths.add(currentPath.toString());
            }
        }
    }
}
