package com.bitlrn.tree;

import java.util.ArrayList;
import java.util.List;

enum Color {
    RED,
    GREEN,
}

/**
 * A Tree class implementing a rooted tree is provided in the editor.
 * It has the following publicly available methods:
 * <p>
 * getValue(): Returns the value stored in the node.
 * getColor(): Returns the color of the node.
 * getDepth(): Returns the depth of the node. Recall that the depth of a node is the number of edges between the node
 * and the tree's root, so the tree's root has depth of 0 and each descendant node's depth is equal to the
 * depth of its parent node +1.
 * <p>
 * In this challenge, we treat the internal implementation of the tree as being closed to modification,
 * so we cannot directly modify it; however, as with real-world situations,
 * the implementation is written in such a way that it allows external classes
 * to extend and build upon its functionality.
 * <p>
 * More specifically, it allows objects of the TreeVis class (a Visitor Design Pattern)
 * to visit the tree and traverse the tree structure via the accept method.
 *
 * <p>
 * There are two parts to this challenge.
 * <p>
 * getResult(): Return an integer denoting the result, which is different for each class:
 * <p>
 * The SumInLeavesVisitor implementation must return the sum of the values in the tree's leaves only.
 * The ProductRedNodesVisitor implementation must return the product of values stored in all red nodes, including leaves, computed modulo . Note that the product of zero values is equal to .
 * The FancyVisitor implementation must return the absolute difference between the sum of values stored in the tree's non-leaf nodes at even depth and the sum of values stored in the tree's green leaf nodes. Recall that zero is an even number.
 * <p>
 * visitNode(TreeNode node): Implement the logic responsible for visiting the tree's non-leaf nodes such that the getResult method returns the correct  for the implementing class' visitor.
 * <p>
 * visitLeaf(TreeLeaf leaf): Implement the logic responsible for visiting the tree's leaf nodes such that the getResult method returns the correct  for the implementing class' visitor.
 * <p>
 * Read the -node tree, where each node is numbered from  to . The tree is given as a list of node values (), a list of node colors (), and a list of edges. Construct this tree as an instance of the Tree class. The tree is always rooted at node number .
 * <p>
 * Your implementations of the three visitor classes will be tested on the tree you built from the given input.
 * <p>
 * Part II: Read and Build the Tree
 * Read the -node tree, where each node is numbered from  to . The tree is given as a list of node values (), a list of node colors (), and a list of edges. Construct this tree as an instance of the Tree class. The tree is always rooted at node number .
 * <p>
 * Your implementations of the three visitor classes will be tested on the tree you built from the given input.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer,n, denoting the number of nodes in the tree. The second line contains  space-separated integers describing the respective values of .
 * The third line contains  space-separated binary integers describing the respective values of . Each  denotes the color of the  node, where  denotes red and  denotes green.
 * Each of the  subsequent lines contains two space-separated integers,  and , describing an edge between nodes  and .
 * <p>
 * Constraints
 * 2 <= n <= 10^5
 * 1 <= x[i] <= 10^3
 * c[i] belongs {0,1}
 * 1 <= v[i],u[i] <= n
 * It is guaranteed that the tree is rooted at node .
 * <p>
 * Output Format
 * <p>
 * Do not print anything to stdout, as this is handled by locked stub code in the editor. The three getResult() methods provided for you must return an integer denoting the  for that class' visitor (defined above). Note that the value returned by ProductRedNodesVisitor's getResult method must be computed modulo .
 */
abstract class TreeGeneric<V, C> {
    private final V value;
    private final C color;
    private final int depth;

    public TreeGeneric(V v, C c, int depth) {
        this.value = v;
        this.color = c;
        this.depth = depth;
    }

    public V getValue() {
        return value;
    }

    public C getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

}

abstract class Tree {
    private final int value;
    private final Color color;
    private final int depth;

    public Tree(int v, Color c, int depth) {
        this.value = v;
        this.color = c;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

}

class TreeNode extends Tree {
    private final List<TreeNode> children = new ArrayList<>();

    public TreeNode(int v, Color c, int depth) {
        super(v, c, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (TreeNode treeNode : children) {
            treeNode.accept(visitor);
        }
    }

    public void addChildNode(TreeNode node) {
        children.add(node);
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}

class TreeLeaf extends Tree {
    public TreeLeaf(int v, Color c, int depth) {
        super(v, c, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}
