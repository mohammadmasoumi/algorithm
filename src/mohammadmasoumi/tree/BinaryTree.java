package mohammadmasoumi.tree;

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

    }

    private Node rootNode;


    /**
     * @param value
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
                    currentNode = currentNode.getLeftNode();
            }
        }
    }

}
