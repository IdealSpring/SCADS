package cn.ccut.design.algorithm.tree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(150);
        tree.insert(90);
        tree.insert(250);
        tree.insert(200);
        tree.insert(300);
        tree.insert(210);
        tree.insert(205);
        tree.insert(80);

        tree.orderTraverse();
        System.out.println("Number of element in the tree: " + tree.getSize());
        System.out.println();

        tree.removeNode(150);
        tree.orderTraverse();
        System.out.println("Number of element in the tree: " + tree.getSize());
        System.out.println();

        tree.removeNode(200);
        tree.removeNode(250);
        tree.orderTraverse();
        System.out.println("Number of element in the tree: " + tree.getSize());
        System.out.println();
    }
}
