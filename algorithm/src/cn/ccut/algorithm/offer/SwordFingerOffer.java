package cn.ccut.algorithm.offer;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 剑指Offer算法题
 *
 * @author zhipeng_Tong 2019年2月17日08:54:10
 */
public class SwordFingerOffer {
    public static void main(String[] args) {
        SwordFingerOffer offer = new SwordFingerOffer();

        offer.printlToMaxOfDigit(3);

    }

    /**
     * 17. 打印从 1 到最大的 n 位数
     *
     * @param n
     */
    public void printlToMaxOfDigit(int n) {
        if (n < 0)
            return;

        char[] number = new char[n];
        printlToMaxOfDigit(number, 0);
    }

    private void printlToMaxOfDigit(char[] number, int index) {
        if (index == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            printlToMaxOfDigit(number, index + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;

        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }

    /**
     * 16. 数值的整数次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;

        double result = Power(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;

        return result;
    }

    /**
     * 15. 二进制中 1 的个数
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
//        return Integer.bitCount(n);

        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    /**
     * 14. 剪绳子
     *  贪心算法实现
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3 -= 1;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }

    /**
     * 13. 机器人的运动范围
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <=0)
            return 0;

        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);

        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        if (checkPara(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;
            count += 1;
            for (int[] n : next)
                count += movingCountCore(threshold, rows, cols, row + n[0], col + n[1], visited);
        }

        return count;
    }

    private boolean checkPara(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    /**
     * 12. 矩阵中的路径
     *
     * @param matrix
     * @param cols
     * @param str
     * @return
     */
    private final int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows;
    private int cols;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // 参数校验
        if (rows == 0 || cols == 0)
            return false;

        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];   // 防止走重复点
        char[][] matrix2 = buildMatrix(matrix);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix2, str, marked, 0, i, j))
                    return true;

        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int row, int col) {
        // 结束条件
        if (pathLen == str.length)
            return true;
        if (row < 0 || row >= this.rows || col < 0 || col >= this.cols || matrix[row][col] != str[pathLen] || marked[row][col])
            return false;

        marked[row][col] = true;
        for (int[] n : next)
            if (backtracking(matrix, str, marked, pathLen + 1, row + n[0], col + n[1]))
                return true;

        // 递归使用，很巧妙
        marked[row][col] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[this.rows][this.cols];
        for (int i = 0, index = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[index++];
            }
        }
        return matrix;
    }

    /**
     * 11. 旋转数组的最小数字
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0)
            return 0;

        int low = 0, height = array.length - 1;
        int mid;
        while (low < height) {
            mid = (low + height) / 2;
            if (array[mid] <= array[height])
                height = mid;
            else
                low = mid + 1;
        }

        return array[low];
    }

    /**
     * 10.3 矩形覆盖
     *
     * @param n
     * @return
     */
    public int RectCover(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    /**
     * 10.2 青蛙跳台阶
     *
     * @param n
     * @return
     */
    public int jumpFloor(int n) {
        if (n <= 2)
            return n;

        int pre1 = 2, pre2 = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }

        return result;
    }

    /**
     * 10.1 斐波那契数列
     *
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n <= 1)
            return n;

        int nDecreaseTwo = 0, nDecreaseOne = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = nDecreaseTwo + nDecreaseOne;
            nDecreaseTwo = nDecreaseOne;
            nDecreaseOne = fib;
        }

        return fib;
    }

    /**
     * 9. 用两个栈实现队列
     */
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.pop();
    }

    /**
     * 8. 二叉树的下一个结点
     *
     * @param pNode
     * @return
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }

        return null;
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 7. 重建二叉树
     * <p>
     * preorder = [3,9,20,15,7]
     * inorder =  [9,3,15,20,7]
     *
     * @param pre
     * @param in
     * @return
     */
    private HashMap<Integer, Integer> indexForInOrders = new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);

        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     *
     * @param pre   前序遍历数组
     * @param preL  左索引
     * @param preR  右索引
     * @param inL   中序遍历的左侧
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        // 递归结束条件
        if (preL > preR)
            return null;

        TreeNode root = new TreeNode(pre[preL]);    // 根节点
        int inIndex = indexForInOrders.get(root.val);   // 根节点在中序遍历中的位置索引
        int leftTreeSize = inIndex - inL;   // 左子树元素个数

        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + 1 + leftTreeSize, preR, inL + leftTreeSize + 1);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 6. 从尾到头打印链表
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }

        return ret;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 5.替换空格
     *
     * 将一个字符串中的空格替换成 "%20"。
     *
     * Input:
     * "A B"
     *
     * Output:
     * "A%20B"
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer  str) {
        if (str.length() == 0)
            return "";

        int p1 = str.length() - 1;

        for (int i = 0; i <= p1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        int p2 = str.length() - 1;
        char c;
        while (p1 >= 0 && p2 > p1) {
            if ((c = str.charAt(p1--)) != ' ') {
                str.setCharAt(p2--, c);
            } else {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
        }

        return str.toString();
    }

    /**
     * 4. 二维数组中的查找
     *
     * @param target
     * @param matrix
     * @return
     */
    public boolean find(int target, int[][] matrix) {
        // 对非法输入的检查
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1;    // 从右上角开始
        while (r < rows && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target < matrix[r][c])
                c--;
            else
                r++;
        }

        return false;
    }

    /**
     * 3. 数组中重复的数字
     *
     * @param nums
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        // 数组检查
        if (nums == null || length <= 0)
            return false;

        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }

        return false;
    }

    /**
     * 交换元素位置
     *
     * @param nums  数组
     * @param i 待交换元素
     * @param j 待交换元素
     */
    private void swap(int[] nums, int i, int j) {

    }
}
