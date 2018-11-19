package cn.ccut.design.algorithm.tree;

/**
 * 二叉树测试类
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) throws Exception {
        BinarySearchTree bt = new BinarySearchTree(50);
        bt.insert(30);
        bt.insert(80);
        bt.insert(10);
        bt.insert(40);
        bt.insert(35);
        bt.insert(60);
        bt.insert(90);
        bt.insert(70);
        bt.insert(83);
        bt.insert(95);
        bt.insert(75);
        bt.insert(88);

        bt.preOrderTtaverse();
        bt.preOrderByStack();

        bt.inOrderTraverse();
        bt.inOrderByStack();

        bt.postOrderTraverse();
        bt.postOrderByStack();

        System.out.println("查询的777 : " + bt.findKey(777));
        System.out.println("最小值: " + bt.getMinValue());
        System.out.println("最大值: " + bt.getMaxValue());

        System.out.println();
        System.out.println("行式打印：");
        bt.printBinaryTreeByRow();
        System.out.println();
        System.out.println("列式打印：");
        bt.printBinaryTreeByColumn();
        System.out.println();

        bt.removeNode(32);      //删除叶子节点//
        bt.removeNode(50);      //删除只有一个左子节点的节点
        bt.removeNode(248);      //删除只有一个右子节点的节点
        bt.removeNode(248);      //删除只有一个右子节点的节点
        bt.removeNode(580);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点的左后代
        bt.removeNode(888);      //删除有两个子节点的节点，且后继节点为删除节点的右子节点
        bt.removeNode(52);       //删除有两个子节点的节点，且删除节点为根节点

        System.out.println("行式打印：");
        bt.printBinaryTreeByRow();
        System.out.println();
        System.out.println("列式打印：");
        bt.printBinaryTreeByColumn();

    }
}
