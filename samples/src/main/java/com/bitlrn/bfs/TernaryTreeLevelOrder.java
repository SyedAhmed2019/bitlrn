package com.bitlrn.bfs;

import com.bitlrn.tree.basic.TernaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TernaryTreeLevelOrder<T extends Comparable<T>> extends TernaryTree<T> {
    public static void main(String[] args) {
        TernaryTreeLevelOrder<Integer> ternaryTreeLevelOrder = new TernaryTreeLevelOrder<>();
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        TernaryTreeNode<Integer> root = null;
        // 0, 1, 2 , 3 ,4 5, 6 ,7, 8, 9
        for (int i = 0; i < nodes; ++i) {
            if (i == 0) {
                root = ternaryTreeLevelOrder.createTree(null, scanner.nextInt());
            } else if (i % 3 != 0) {
                ternaryTreeLevelOrder.createTree(root, scanner.nextInt());
            }
        }
        ternaryTreeLevelOrder.displayLevelOrder(root);
    }

    private void displayLevelOrder(TernaryTreeNode<T> root) {
        Deque<TernaryTreeNode<T>> queue = new ArrayDeque<>();
        if (root != null) {
            queue.push(root);
            while (!queue.isEmpty()) {
                TernaryTreeNode<T> current = queue.pop();
                System.out.println(current.data);
                for (TernaryTreeNode<T> node : current.children) {
                    queue.push(node);
                }
            }
        }
    }
}
