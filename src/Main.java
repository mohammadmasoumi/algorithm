import mohammadmasoumi.tree.BinaryTree;

public class Main {


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

//        System.out.println(tree.find(7));
//        System.out.println(tree.find(11));

//        System.out.println("--- traversePreOrderDFS ---");
//        tree.traversePreOrderDFS();
//
//        System.out.println("--- traverseInOrderDFS ---");
//        tree.traverseInOrderDFS();
//
//        System.out.println("--- traversePostOrderDFS ---");
//        tree.traversePostOrderDFS();

        System.out.println("--- traverseBFS ---");
        tree.traverseBFS();
    }
}


