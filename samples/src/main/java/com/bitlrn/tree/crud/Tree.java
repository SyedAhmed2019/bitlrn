package com.bitlrn.tree.crud;

import java.util.*;

public class Tree<T> {
    private final int shortestPath = 0;
    Queue<Node> queue = new LinkedList<>();
    Set<Node> visitedNode = new HashSet<>();

    static void decode(String s, Node root) {
        if (root == null || s.length() == 0) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.data);
        }

        Node currentNode = root;
        while (!s.isEmpty()) {
            char current = s.charAt(0);
            switch (current) {
                case '0':
                    if (currentNode.left != null) {
                        currentNode = currentNode.left;
                    } else {
                        System.out.println(currentNode.data);
                    }

                    break;
                case '1':
                    if (currentNode.right != null) {
                        currentNode = currentNode.right;
                    } else {
                        System.out.println(currentNode.data);
                    }
                    break;
            }
            if (currentNode != null) {
                if (currentNode.left == null && currentNode.right == null) {
                    System.out.println(currentNode.data);
                    currentNode = root;
                }
                if (s.length() > 1) {
                    s = s.substring(1);
                } else {
                    s = "";
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 if you want binary tree:");
        int treeType = scanner.nextInt();
        Tree<Integer> tree = new Tree();
        Node<Integer> root = null;
        if (treeType == 1) {
            int value;
            while ((value = scanner.nextInt()) != -1) {
                root = tree.binaryInsert(root, value);
            }
        } else {
            root = tree.create();
        }
        System.out.println("inorder traversal");
        tree.inorderTraversal(root);
        System.out.println("\n");
        System.out.println("preorder traversal");
        tree.preorderTraversal(root);
        System.out.println("\n");
        System.out.println("postorder traversal");
        tree.postorderTraversal(root);

        System.out.println("Enter the type of search (1.DFS 2.BFS).");

        if (scanner.nextInt() == 1) {
            System.out.println("Enter element to search ");
            System.out.println(tree.searchDfs(root, scanner.nextInt()));
        } else {
            System.out.println("Enter element to search ");
            System.out.println(tree.searchBfs(root, scanner.nextInt()));
        }

        // decode based on huffman code
        decode("1001011", root);


    }

    public void inorderTraversal(Node rootNode) {
        if (rootNode != null && rootNode.getLeft() != null) {
            inorderTraversal(rootNode.getLeft());
        }
        if (rootNode != null) {
            System.out.print(rootNode.getData() + " ");
        }
        if (rootNode != null && rootNode.getRight() != null) {
            inorderTraversal(rootNode.getRight());
        }
    }

    public void preorderTraversal(Node rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.getData() + " ");
        }
        if (rootNode.getLeft() != null) {
            preorderTraversal(rootNode.getLeft());
        }
        if (rootNode.getRight() != null) {
            preorderTraversal(rootNode.getRight());
        }
    }

    public void postorderTraversal(Node rootNode) {
        if (rootNode.getLeft() != null) {
            postorderTraversal(rootNode.getLeft());
        }
        if (rootNode.getRight() != null) {
            postorderTraversal(rootNode.getRight());
        }
        if (rootNode != null) {
            System.out.print(rootNode.getData() + " ");
        }
    }

    /**
     * Drawbacks-- depth first search cannot reliably return the
     * Need to comeback.
     * level and the result. You can just use it to indicate whether
     * the element was found or not.
     *
     * @param rootNode
     * @param value
     * @return
     */
    public boolean searchDfs(Node rootNode, T value) {
        if (rootNode == null) {
            return false;
        }
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.data.equals(value)) {
                System.out.println("found the value");
                return true;
            }
            if (!searchDfs(curr.left, value)) {
                return searchDfs(curr.right, value);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchBfs(Node rootNode, T value) {
        Queue<Node> bfsQueue = new LinkedList<>();
        Set<Node> bfsVisited = new HashSet<>();
        int shortPath = 0;

        if (rootNode == null) {
            return false;
        }
        queue.add(rootNode);
        bfsVisited.add(rootNode);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr != null && curr.data.equals(value)) {
                System.out.println("found the value at shortestPath " + shortPath);
                return true;
            }
            if (curr.left != null && !bfsVisited.contains(curr.left)) {
                queue.add(curr.left);
            }
            if (curr.right != null && !bfsVisited.contains(curr.right)) {
                queue.add(curr.right);
            }
            shortPath++;

        }
        return false;
    }

    public Node binaryInsert(Node<Integer> root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.getData()) {
                cur = binaryInsert(root.left, data);
                root.left = cur;
            } else {
                cur = binaryInsert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public Node<Integer> create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of the node or -1");
        Integer value = scanner.nextInt();
        if (value == -1) {
            return null;
        }
        Node<Integer> node = new Node<>(value);
        System.out.println("Enter the left node value of " + value);
        Node<Integer> nodeLeft = create();
        System.out.println("Enter the right node value of " + value);
        Node<Integer> nodeRight = create();
        node.setLeft(nodeLeft);
        node.setRight(nodeRight);
        return node;
    }

    static class Node<T> {
        private Node left;
        private Node right;
        private T data;

        Node(T data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node<T> nodeLeft) {
            left = nodeLeft;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node<T> nodeRight) {
            right = nodeRight;
        }

        public T getData() {
            return data;
        }

        public void setData(T value) {
            this.data = value;
        }
    }
}

