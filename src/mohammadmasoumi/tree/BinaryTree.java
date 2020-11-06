package mohammadmasoumi.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    /**
     *
     */
    private class Node {

        private final int value;
        private Node leftNode;
        private Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return "Node: " + value;
        }

        public boolean isLeafNode() {
            return leftNode == null && rightNode == null;
        }

    }

    private Node rootNode;

    /**
     * @param value newNode's value
     */
    public void insert(int value) {
        var newNode = new Node(value);

        if (rootNode == null) {
            rootNode = newNode;
            return;
        }

        var currentNode = rootNode;

        while (true) {
            if (value < currentNode.getValue()) {
                var leftNode = currentNode.getLeftNode();
                if (leftNode == null) {
                    currentNode.setLeftNode(newNode);
                    break;
                } else
                    currentNode = currentNode.getLeftNode();
            } else {
                var rightNode = currentNode.getRightNode();
                if (rightNode == null) {
                    currentNode.setRightNode(newNode);
                    break;
                } else
                    currentNode = currentNode.getRightNode();
            }
        }
    }

    /**
     * @param value node's value
     * @return whether the value is in the tree true or not
     */
    public boolean find(int value) {
        var currentNode = rootNode;

        while (currentNode != null) {
            if (value < currentNode.getValue())
                currentNode = currentNode.getLeftNode();
            else if (value > currentNode.getValue())
                currentNode = currentNode.getRightNode();
            else
                return true;
        }

        return false;
    }

    /**
     * @return height of the tree
     */
    public int height() {
        return height(rootNode);
    }

    /**
     * @param node rootNode
     * @return height of the tree
     */
    private int height(Node node) {
        if (node == null)
            return -1;

        if (node.isLeafNode())
            return 0;

        return Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1;
    }

    /**
     * @return minimum value in the tree
     */
    public int minValue() {
        return minValue(rootNode);
    }

    /**
     * @param node rootNode
     * @return minimum value in the tree
     */
    private int minValue(Node node) {
        if (node.isLeafNode())
            return node.getValue();

        return Math.min(
                rootNode.getValue(),
                Math.min(minValue(node.getLeftNode()), minValue(node.getRightNode()))
        );
    }

    /**
     *
     */
    public void traverseBFS() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(rootNode);
        traverseBFS(nodes);
    }

    /**
     * @param nodes nodes to traverse
     */
    private void traverseBFS(List<Node> nodes) {
        if (nodes.isEmpty())
            return;

        int nodesSize = nodes.size();
        Node currentNode, leftNode, rightNode;

        for (int i = 0; i < nodesSize; i++) {
            currentNode = nodes.get(0);
            System.out.println(currentNode.getValue());

            leftNode = currentNode.getLeftNode();
            rightNode = currentNode.getRightNode();

            nodes.remove(currentNode);

            if (leftNode != null)
                nodes.add(leftNode);

            if (rightNode != null)
                nodes.add(rightNode);
        }
        traverseBFS(nodes);
    }

    /**
     *
     */
    public void traversePreOrderDFS() {
        traversePreOrderDFS(rootNode);
    }

    /**
     * pre-order DFS: root, left, right
     * <p>
     * 7
     * 4     9
     * 1   6 8   10
     *
     * @param root rootNode
     */
    private void traversePreOrderDFS(Node root) {
        if (root == null)
            return;

        System.out.println(root.getValue());
        traversePreOrderDFS(root.getLeftNode());
        traversePreOrderDFS(root.getRightNode());
    }

    /**
     *
     */
    public void traverseInOrderDFS() {
        traverseInOrderDFS(rootNode);
    }

    /**
     * pre-order DFS: left, root, right
     * <p>
     * 7
     * 4     9
     * 1   6 8   10
     *
     * @param root rootNode
     */
    private void traverseInOrderDFS(Node root) {
        if (root == null)
            return;

        traverseInOrderDFS(root.getLeftNode());
        System.out.println(root.getValue());
        traverseInOrderDFS(root.getRightNode());
    }

    /**
     *
     */
    public void traversePostOrderDFS() {
        traversePostOrderDFS(rootNode);
    }

    /**
     * pre-order DFS: left, right, root
     * <p>
     * 7
     * 4     9
     * 1   6 8   10
     *
     * @param root rootNode
     */
    private void traversePostOrderDFS(Node root) {
        if (root == null)
            return;

        traversePostOrderDFS(root.getLeftNode());
        traversePostOrderDFS(root.getRightNode());
        System.out.println(root.getValue());
    }


}
