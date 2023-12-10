package com.bitlrn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    TreeNode buildTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number of nodes in tree:");
        int treeSize = scanner.nextInt();
        System.out.println("Enter " + treeSize + " node values:");
        List<Integer> nodeValues = new ArrayList<>();
        for (int i = 0; i < treeSize; ++i) {
            nodeValues.add(scanner.nextInt());
        }
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < treeSize; ++i) {
            if (scanner.nextInt() == Color.GREEN.ordinal()) {
                colors.add(Color.GREEN);
            } else {
                colors.add(Color.RED);
            }
        }
        TreeNode rootNode = new TreeNode(nodeValues.get(0), colors.get(0), 1);
        for (int i = 1; i < treeSize; ++i) {
            if (nodeValues.get(i) < rootNode.getValue()) {
                if (!rootNode.getChildren().isEmpty()) {

                }
            } else {
                rootNode.addChildNode(new TreeNode(nodeValues.get(i), colors.get(i), i + 1));
            }
        }
        return null;
    }
}
