package cn.ccut.algorithm.tree;

import com.sun.org.apache.xalan.internal.xsltc.dom.NodeIteratorBase;
import org.hamcrest.core.IsNull;

/**
 * 红黑树
 */
public class RedBlackTree<T extends Comparable<T>> {
    /**
     * 红黑树节点
     */
    static class RedBlackNode<T extends Comparable<T>> {
        T key;  // 节点值
        boolean red;    // 是否是红色节点

        RedBlackNode<T> parent; // 父节点
        RedBlackNode<T> leftChild; // 父节点
        RedBlackNode<T> rightChild; // 父节点

        public RedBlackNode() {
        }

        public RedBlackNode(T key) {
            this();
            this.key = key;
        }

        public boolean isRed() {
            return red;
        }

        @Override
        public String toString() {
            return key + "";
        }
    }

    private final RedBlackNode<T> NIL = new RedBlackNode<>();   // 哨兵节点(叶子结点)
    private RedBlackNode<T> root = NIL; // 根节点
    private int size;   // 元素数量

    public RedBlackTree() { // 构造方法
        root.parent = NIL;
        root.leftChild = NIL;
        root.rightChild = NIL;
    }

    // 插入数据分两步：1.数据插入 2.根据红黑树性质修正树
    public void insert(T key) {
        if (key == null || key == "")   // 数据检查
            return;

        insert(new RedBlackNode<T>(key));
    }
    // 1.数据插入
    private void insert(RedBlackNode<T> node) {
        RedBlackNode<T> parent = NIL;   // index的父节点
        RedBlackNode<T> index = root;   // 索引

        while (!isNil(index)) { // 循环遍历，找到插入位置和父节点
            parent = index;

            if (node.key.compareTo(index.key) < 0) {
                index = index.leftChild;
            } else if (node.key.compareTo(index.key) > 0) {
                index = index.rightChild;
            } else {    // 找到相等节点，结束程序
                return;
            }
        }

        // 将孩子指向父亲
        node.parent = parent;
        size++;

        // 将父亲指向孩子，分情况讨论：
        // 1.父节点是NIL(当前树为空，没有根节点)
        if (isNil(parent))
            root = node;
        // 2.父亲的左孩子
        else if (node.key.compareTo(parent.key) < 0)
            parent.leftChild = node;
        // 3.父亲的右孩子
        else
            parent.rightChild = node;

        // 初始化孩子和颜色(新添加的节点一定是红色)
        node.leftChild = NIL;
        node.rightChild = NIL;
        node.red = true;

        // 2.红黑树插入修正
        insertFixup(node);
    }

    /**
     * 插入修正
     *
     * @param node  插入的节点
     */
    private void insertFixup(RedBlackNode<T> node) {
        RedBlackNode<T> cousinNode = NIL;   //叔节点

        // 循环修正节点
        // 新插入节点的父亲为红色，则不满足性质4(如果该节点是红色，则其两个孩子节点必须是黑色)
        while (node.parent.isRed()) {

            // node节点的 [父亲] 是 [爷爷] 节点的 [左孩子]
            if (node.parent == node.parent.parent.leftChild) {
                // 初始化node的叔叔(父节点的兄弟)
                cousinNode = node.parent.parent.rightChild;

                // 情况3.cousinNode(叔叔节点)是红节点
                if (cousinNode.isRed()) {
                    node.parent.red = false;    // node父节点置为黑
                    cousinNode.red = false;     // node叔节点置为黑
                    node.parent.parent.red = true;  // node的爷爷节点置红
                    node = node.parent.parent;
                }
                // 情况4.cousinNode节点为[黑节点]且为父节点[左孩子]
                else if (node == node.parent.leftChild) {
                    // 重置颜色、以node的爷爷旋转
                    node.parent.red = false;
                    node.parent.parent.red = true;
                    rightRotate(node.parent.parent);
                }
                // 情况4.cousinNode节点为[黑节点]且为父节点[右孩子]
                else {
                    // 以node的父亲左旋
                    node = node.parent;
                    leftRotate(node);
                }
            }
            // node节点的 [父亲] 是 [爷爷] 节点的 [右孩子]
            else {
                // 初始化node的叔叔(父节点的兄弟)
                cousinNode = node.parent.parent.leftChild;

                // 情况1.cousinNode(叔叔节点)是红节点
                if (cousinNode.isRed()) {
                    node.parent.red = false;    // node父节点置为黑
                    cousinNode.red = false;     // node叔节点置为黑
                    node.parent.parent.red = true;  // node的爷爷节点置红
                    node = node.parent.parent;
                }
                // 情况2.cousinNode节点为[黑节点]且为父节点[左孩子]
                else if (node == node.parent.leftChild) {
                    node = node.parent;
                    // 以node的父亲右旋
                    rightRotate(node);
                }
                // 情况3.cousinNode节点为[黑节点]且为父节点[右孩子]
                else {
                    // 重置颜色、以node的爷爷旋转
                    node.parent.red = false;
                    node.parent.parent.red = true;
                    leftRotate(node.parent.parent);
                }
            }
        }

        // 颜色根部始终为黑色
        // 情况1：新插入节点N为根节点
        root.red = false;
    }

    /**
     * 右旋操作
     *
     * @param node  旋转的轴节点
     */
    private void rightRotate(RedBlackNode<T> node) {
        RedBlackNode<T> nodeLeftChild = node.leftChild;  // node左孩子
        node.leftChild = nodeLeftChild.rightChild;  // 将node的左孩子的右孩子过继给node，作为它的左孩子

        if (!isNil(nodeLeftChild.rightChild))   // node的左孩子的右孩子不为NIL
            nodeLeftChild.rightChild.parent = node; // 将node作为它的父亲
        nodeLeftChild.parent = node.parent; // 将nodeLeftChild的父域指向node的父亲

        // 如果node的父亲NIL
        if (isNil(node.parent))
            root = nodeLeftChild;
        // node是其父节点的左孩子
        else if (node.parent.leftChild == node)
            node.parent.leftChild = nodeLeftChild;
        // node是其父节点的右孩子
        else
            node.parent.rightChild = nodeLeftChild;

        // 最后的旋转
        nodeLeftChild.rightChild = node;
        node.parent = nodeLeftChild;
    }

    /**
     * 左旋操作
     *
     * @param node  旋转的轴节点
     */
    private void leftRotate(RedBlackNode<T> node) {
        RedBlackNode<T> nodeRightChild = node.rightChild; // node的右孩子
        node.rightChild = nodeRightChild.leftChild; // 将node的右孩子的左孩子过继给node，作为它的右孩子

        if (!isNil(nodeRightChild.leftChild))  // node的右孩子的左孩子不为NIL
            nodeRightChild.leftChild.parent = node; // 将node作为它的父亲
        nodeRightChild.parent = node.parent;    // 将nodeRightChild的父域指向node的父亲

        // 如果node的父亲NIL
        if (isNil(node.parent))
            root = nodeRightChild;
        // node是其父节点的左孩子
        else if (node.parent.leftChild == node)
            node.parent.leftChild = nodeRightChild;
        // node是其父节点的右孩子
        else
            node.parent.rightChild = nodeRightChild;

        // 最后的旋转
        nodeRightChild.leftChild = node;
        node.parent = nodeRightChild;
    }

    // 判断节点是否是Nil(哨兵)
    private boolean isNil(RedBlackNode<T> node) {
        return node == this.NIL;
    }

    public void preOrderErgodic(){
        preOrderErgodic(this.root);
    }

    /**
     * 前序遍历红黑树
     * @param node
     */
    public void preOrderErgodic(RedBlackNode node){
        if (node != this.NIL) {
            System.out.print(node.key + "\tC:" + (node.red ? "Red" : "Black") + "\t\t");

            if (node.leftChild != this.NIL)
                System.out.print( "(L)" + node.leftChild.key + "\t\t");
            else
                System.out.print("(L)Null\t\t");

            if (node.rightChild != this.NIL)
                System.out.print("(R)" + node.rightChild.key + "\t\t");
            else
                System.out.print("(R)Null\t\t");

            System.out.println();
            preOrderErgodic(node.leftChild);
            preOrderErgodic(node.rightChild);
        }
    }

    // 返回树节点数
    public int getSize() {
        return size;
    }

    /**
     * 删除节点
     *
     * @param t 要删除的节点
     */
    public void remove(T t) {
        if (t == null || t == "")   // 简单的错误检查
            return;

        removeNode(new RedBlackNode<T>(t));
        size--;
    }
    // 移除节点
    private void removeNode(RedBlackNode<T> v) {
        RedBlackNode<T> waitRemoveNode = search(v.key); // 查找待删除节点
        RedBlackNode<T> successorNode = NIL;    // 后继节点
        RedBlackNode<T> successorChild = NIL;   // 后继的子节点

        // waitRemoveNode没有孩子节点，或者有一个孩子节点的情况
        if (isNil(waitRemoveNode.leftChild) || isNil(waitRemoveNode.rightChild))
            successorNode = waitRemoveNode;
        else    // waitRemoveNode有两个孩子节点的情况
            successorNode = treeSuccessor(waitRemoveNode);


        if (!isNil(successorNode.leftChild))    // 获取后继的孩子
            successorChild = successorNode.leftChild;
        else
            successorChild = successorNode.rightChild;

        successorChild.parent = successorNode.parent;   //successorChild父域指向successorNode父亲

        if (isNil(successorNode.parent))    // 如果successorNode父亲为空
            root = successorChild;
        // 左孩子
        else if (!isNil(successorNode.parent.leftChild) && successorNode.parent.leftChild == successorNode)
            successorNode.parent.leftChild = successorChild;
        // 右孩子
        else if (!isNil(successorNode.parent.rightChild) && successorNode.parent.rightChild == successorNode)
            successorNode.parent.rightChild = successorChild;

        // 待删除节点已从树中移除，复制值
        if (successorNode != waitRemoveNode)
            waitRemoveNode.key = successorNode.key;

        if (!successorNode.red) // 如果后继为黑节点，需要平衡红黑树
            removeFixup(successorChild);
    }

    /**
     * 删除节点后修复红黑树
     *
     * @param node  为黑色的后继节点
     */
    private void removeFixup(RedBlackNode<T> node) {
        RedBlackNode<T> nodeBrothers;   // node的兄弟节点

        // node不是根节点，且颜色为黑色
        while (node != root && node.red == false) {

            // 如果node是其父亲的左孩子
            if (node.parent.leftChild == node) {
                nodeBrothers = node.parent.rightChild;  // node父亲的右孩子即为node的兄弟

                // 1.node兄弟节点为红色
                if (nodeBrothers.red == true) {
                    nodeBrothers.red = false;
                    nodeBrothers.parent.red = true;
                    leftRotate(nodeBrothers.parent);
                    nodeBrothers = node.parent.rightChild;
                }

                // 2.node兄弟节点的左右孩子都为黑色
                if (nodeBrothers.leftChild.red == false && nodeBrothers.rightChild.red == false) {
                    nodeBrothers.red = true;
                    node = node.parent;
                } else {
                    // 3.node兄弟节点的右孩子为黑色
                    if (nodeBrothers.rightChild.red == false) {
                        nodeBrothers.leftChild.red = false;
                        nodeBrothers.red = true;
                        rightRotate(nodeBrothers);
                        nodeBrothers = node.parent.rightChild;
                    }

                    // 4.node兄弟节点为黑色, node兄弟节点的右孩子为红色
                    nodeBrothers.red = node.parent.red;
                    node.parent.red = false;
                    nodeBrothers.rightChild.red = false;
                    leftRotate(node.parent);
                    node = root;
                }
            }
            // node是父亲的右孩子
            else {
                nodeBrothers = node.parent.leftChild;  // node父亲的左孩子即为node的兄弟

                // 1.nodeBrothers为红色
                if (nodeBrothers.red == true) {
                    nodeBrothers.red = false;
                    nodeBrothers.parent.red = true;
                    rightRotate(nodeBrothers.parent);
                    nodeBrothers = node.parent.leftChild;
                }

                // 2.nodeBrothers的孩子节点都是黑色
                if (nodeBrothers.leftChild.red == false && nodeBrothers.rightChild.red == false) {
                    nodeBrothers.red = true;
                    node = node.parent;
                } else {
                    // 3.nodeBrothers的左孩子是黑色
                    if (nodeBrothers.leftChild.red == false) {
                        nodeBrothers.rightChild.red = false;
                        nodeBrothers.red = true;
                        leftRotate(nodeBrothers);
                        nodeBrothers = node.parent.leftChild;
                    }

                    // 4.nodeBrothers是黑色，nodeBrothers的左孩子是红色
                    nodeBrothers.red = node.parent.red;
                    node.parent.red = false;
                    nodeBrothers.leftChild.red = false;
                    rightRotate(node.parent);
                    node = root;
                }
            }
        }

        // 设置节点为黑色，保证满足红黑树的特性
        node.red = false;
    }

    private RedBlackNode<T> treeSuccessor(RedBlackNode<T> waitRemoveNode) {
        if (!isNil(waitRemoveNode.leftChild))
            return treeMinimum(waitRemoveNode.rightChild);

        return null;
    }

    // 获取以node为根节点的子树的最小节点
    private RedBlackNode<T> treeMinimum(RedBlackNode<T> node) {
        while (!isNil(node.leftChild))
            node = node.leftChild;

        return node;
    }

    /**
     * 根据值寻找节点
     *
     * @param key   指定的值
     * @return  节点
     */
    private RedBlackNode<T> search(T key) {
        RedBlackNode<T> index = root;   // 指针

        while (!isNil(index)) { // 循环遍历
            if (key.equals(index.key))  // 找到了直接返回
                return index;
            else if (key.compareTo(index.key) < 0)  // 小于取左
                index = index.leftChild;
            else    // 大于取右
                index = index.rightChild;
        }

        return null;    // 未找到节点返回null
    }
}
