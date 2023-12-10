package com.bitlrn.tree.basic;

public class SerDerTree<T extends Comparable<T>> extends Tree<T> {
    public static void main(String[] args) {
        SerDerTree<Integer> serDerTree = new SerDerTree<>();
        // tree data (5, 4, 3, 8, 6);
        serDerTree.prepareTest(args);
        StringBuffer outputBuffer = new StringBuffer();
        serDerTree.serialize(serDerTree.root, outputBuffer);
        System.out.println(outputBuffer);
        if (outputBuffer.toString().equals("5 4 3 * * * 8 6 * * *")) {
            System.out.println("SUCCESS");
        }
        TreeNode<Integer> root = serDerTree.deserialize(outputBuffer.toString());
        serDerTree.displayTree(root, Mode.PREORDER);

    }

    /**
     * Serializes a tree into a string the format will be as follows (uses pre-order traversal while serializing)
     * (N0 LN0 LN1 LN2 LN3 RN3 * * * * RN1 * * * RN0 * *)  = when child is null we have *
     * N0
     * LN0     RN0
     * LN1   *   *  *
     * LN2   RN1
     * LN3  *  *  *
     * *    RN3
     * *   *
     *
     * @param root
     * @return String serialize/deserialize
     */

    private void serialize(TreeNode<T> root, StringBuffer resultBuffer) {
        if (root != null) {
            resultBuffer.append(root.data).append(" ");
            serialize(root.left, resultBuffer);
            serialize(root.right, resultBuffer);

        } else {
            resultBuffer.append("* ");
        }
    }

    private TreeNode<T> deserialize(String serOut) {
        String[] input = serOut.split(" ");
        TreeNode<T> root = null;
        for (int i = 0; i < input.length; ++i) {
            if (!input[i].equals("*")) {
                root = createTree(root, (T) Integer.valueOf(input[i]));
            }
        }
        return root;
    }
}
