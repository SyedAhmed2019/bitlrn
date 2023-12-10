package com.bitlrn.tree;

abstract public class TreeVis {
    abstract public void visitNode(TreeNode vcdTreeNode);

    abstract public void visitLeaf(TreeLeaf vcdNode);

    abstract public int getResult();
}

class SumInLeavesVisitor extends TreeVis {
    private Integer sumOfLeaves;

    public int getResult() {
        //implement this
        return sumOfLeaves;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        sumOfLeaves += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private int product;

    public ProductOfRedNodesVisitor() {
        product = 1;
    }

    public int getResult() {
        return (int) ((double) product % (Math.pow(10, 9) + 7));
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product *= node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product *= leaf.getValue();
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumOfNodesAtEvenDepth;
    private int sumOfLeafWithGreenColor;

    public int getResult() {
        //implement this
        return sumOfNodesAtEvenDepth - sumOfLeafWithGreenColor;
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            sumOfNodesAtEvenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            sumOfLeafWithGreenColor += leaf.getValue();
        }
    }
}



