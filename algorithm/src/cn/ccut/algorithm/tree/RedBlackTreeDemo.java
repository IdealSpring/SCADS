package cn.ccut.algorithm.tree;

public class RedBlackTreeDemo {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

//        tree.insert(10);
//        tree.insert(9);
//        tree.insert(8);
//        tree.insert(7);
//        tree.insert(6);
//        tree.insert(5);
//        tree.insert(4);
//        tree.insert(3);
//        tree.insert(2);
//        tree.insert(1);

        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(25);
        tree.insert(51);
        tree.insert(66);
        tree.insert(66);

        System.out.println("The number of node in the tree: " + tree.getSize());
        tree.preOrderErgodic();

//        tree.remove(7);
        tree.remove(40);

        System.out.println("The number of node in the tree: " + tree.getSize());
        tree.preOrderErgodic();
    }
}
