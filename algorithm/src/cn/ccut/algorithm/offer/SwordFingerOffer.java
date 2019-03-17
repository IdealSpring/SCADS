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

//        int[] ar = {1, 3, 2};
//        int[] ar = {5,7,6,9,11,10,8};
        int[] ar = {4,8,6,12,16,14,10};
        System.out.println(offer.VerifySquenceOfBST(ar));
    }

    /**
     * 35. 复杂链表的复制
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        RandomListNode front = pHead;
        while (front != null) {
            RandomListNode copyNode = new RandomListNode(front.label);
            copyNode.next = front.next;
            front.next = copyNode;

            front = copyNode.next;
        }

        front = pHead;
        while (front != null) {
            if (front.random != null) {
                front.next.random = front.random.next;
            }

            front = front.next.next;
        }

        RandomListNode copyHead = pHead.next;
        front = pHead;
        while (front.next != null) {
            RandomListNode next = front.next;
            front.next = next.next;

            front = next;
        }

        return copyHead;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 34. 二叉树中和为某一值的路径
     * 解题思路：
     *
     *
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null || target <= 0)
            return ret;

        FindPath(root, target, new ArrayList<>());
        return ret;
    }

    public void FindPath(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null)   // 用于到达叶子结点，且这条路径上的和不等于目标值
            return;

        target -= node.val;
        path.add(node.val);

        if (node.left == null && node.right == null && target == 0) {
            ret.add(new ArrayList<>(path));
        } else {
            FindPath(node.left, target, path);
            FindPath(node.right, target, path);
        }

        path.remove(path.size() - 1);
    }

    /**
     * 33. 二叉搜索树的后序遍历序列
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        // 有效性检查
        if (sequence == null || sequence.length == 0)
            return false;
        int firstIndex = 0, lastIndex = sequence.length - 1;
        return verify(sequence, firstIndex, lastIndex);
    }

    private boolean verify(int[] sequence, int firstIndex, int lastIndex) {
        if (lastIndex - firstIndex <= 1)    // 就有两个，不管怎么排序，都行
            return true;

        int rootVal = sequence[lastIndex];
        int cutIndex = firstIndex;

        while (cutIndex < lastIndex && sequence[cutIndex] < rootVal)
            cutIndex++;

        for (int i = cutIndex; i < lastIndex; i++) {
            if (sequence[i] < rootVal)
                return false;
        }

        return verify(sequence, firstIndex, cutIndex - 1) && verify(sequence, cutIndex, lastIndex - 1);
    }

    /**
     * 32.3 按之字形顺序打印二叉树
     *
     * @param root
     * @return
     */
//    public ArrayList<ArrayList<Integer> > Print(TreeNode root) {
//        ArrayList<ArrayList<Integer>> ret = new  ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//
//        if (root == null)
//            return ret;
//
//        queue.add(root);
//        boolean flog = false;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            ArrayList<Integer> list = new ArrayList<>();
//            while (size-- > 0) {
//                TreeNode tree = queue.poll();
//                list.add(tree.val);
//
//                if (tree.left != null)
//                    queue.add(tree.left);
//                if (tree.right != null)
//                    queue.add(tree.right);
//            }
//
//            if (flog)
//                Collections.reverse(list);
//            flog = !flog;
//
//            if (list.size() != 0)
//            ret.add(list);
//        }
//
//        return ret;
//    }

    /**
     * 32.2 把二叉树打印成多行
     *
     * @param root
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new  ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return ret;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode tree = queue.poll();
                list.add(tree.val);

                if (tree.left != null)
                    queue.add(tree.left);
                if (tree.right != null)
                    queue.add(tree.right);
            }

            if (list.size() != 0)
                ret.add(list);
        }

        return ret;
    }

    /**
     * 32.1 从上往下打印二叉树
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null)
            return ret;

        queue.add(root);
        TreeNode temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            ret.add(temp.val);

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

        }

        return ret;
    }

    /**
     * 31. 栈的压入、弹出序列
     * 解题思路：
     * 循环遍历将输入序列中数据接入栈中
     *      每向栈中压入一个数据后，比较栈顶数据是否与弹出序列要求元素相等
     *      如果相等，弹出栈顶元素，序列要求元素指针向下移动
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();

        for (int pushIndex = 0, popIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);

            while (popIndex < popA.length && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 30. 包含 min 函数的栈
     */
    /*
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        // minStack.push(minStack.isEmpty() ? node : minStack.pop() > node ?);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
*/
    /**
     * 29. 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++)
                result.add(matrix[r1][i]);

            for (int i = r1 + 1; i <= r2; i++)
                result.add(matrix[i][c2]);

            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)
                    result.add(matrix[r2][i]);

            if (c1 != c2)
                for (int i = r2 - 1; i > r1; i--)
                    result.add(matrix[i][c1]);

            r1++; r2--; c1++; c2--;
        }

        return result;
    }

    /**
     * 28 对称的二叉树
     * 解题思路：
     *      使用递归方法实现(结束条件，镜像对称侧都到达底部)
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    /**
     * 27. 二叉树的镜像
     * 解题思路：
     *      从根节点开始递归内个节点，交换节点的左右子节点(节点不存在时候返回)
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    /**
     * 26. 树的子结构
     * 解题思路：
     *      先使用递归找到与子树值相同的节点
     *      使用递归判断每个字数节点的值
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val)
                result = isSubtree(root1, root2);
            if (!result)
                result = HasSubtree(root1.left, root2);
            if (!result)
                result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    private boolean isSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;
        if (root2 == null)
            return true;
        if (root1.val != root2.val)
            return false;
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }

    /**
     * 25. 合并两个排序的链表
     * 解题思路：
     *      使用递归解决问题
     *      先对特殊数据情况及临界状态进行检测
     *      递归判断出大小并返回
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null && list2 != null)
            return list2;
        if (list1 != null && list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    /**
     * 24. 反转链表
     *
     * 思路：
     *      先创建一个新头结点
     *      将链中的头结点取下来
     *      使用头插法将取下来的链插入到新头结点后
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode preResult = new ListNode(-1);
        ListNode index = head;
        ListNode next;

        while (index != null) {
            next = index.next;
            index.next = preResult.next;
            preResult.next = index;
            index = next;
        }

        return preResult.next;
    }

    /**
     * 23. 链表中环的入口结点
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return null;

        ListNode fast = pHead, slow = pHead;
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    /**
     * 22. 链表中倒数第 K 个结点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k == 0)
            return null;

        ListNode rear = head;
        while (rear != null && k-- > 0)
            rear = rear.next;

        if (k > 0)
            return null;

        ListNode front = head;

        while (rear != null) {
            rear = rear.next;
            front = front.next;
        }

        return front;
    }

    /**
     * 21. 调整数组顺序使奇数位于偶数前面
     *
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int oddCount = 0;
        for (int n : array)
            if (n % 2 == 1)
                oddCount++;

        int[] copys = array.clone();
        int i = 0, j = oddCount;
        for (int copy : copys) {
            if (copy % 2 == 1)
                array[i++] = copy;
            else
                array[j++] = copy;
        }
    }

    /**
     * 20. 表示数值的字符串
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    /**
     * 19. 正则表达式匹配
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null)
            return false;

        int strIndex = 0, patternIndex = 0;
        return match(str, strIndex, pattern, patternIndex);
    }

    private boolean match(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 有效性检测：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;
        // 有效性检测：pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;

        // 模式第二个字符是'*'
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            // 字符串第一个字符和模式第一个字符匹配；有三种情况
            if (strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')){
                return match(str, strIndex, pattern, patternIndex + 2) // 模式后移2位（即x*匹配0个字符）
                        || match(str, strIndex + 1, pattern, patternIndex + 2) // 模式后移2位(即x*匹配1个字符)
                        || match(str, strIndex + 1, pattern, patternIndex); //*匹配一个，再匹配str下一个
            } else { // *模式不匹配，直接后移2位
                return match(str, strIndex, pattern, patternIndex + 2);
            }
        }

        // 模式第二个字符不是'*'，且字符串第一个和模式第一个匹配；否则直接返回false
        if (strIndex != str.length && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) {
            return match(str, strIndex + 1, pattern, patternIndex + 1);
        }

        return false;
    }

    /**
     * 18.2 删除链表中重复的结点
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;

        ListNode resultNode = new ListNode(1);
        resultNode.next = pHead;

        ListNode front = resultNode;
        ListNode rear = pHead;
        while (rear != null) {
            if (rear.next != null && rear.val == rear.next.val) {
                while (rear.next != null && rear.val == rear.next.val)
                    rear = rear.next;

                rear = rear.next;
                front.next = rear;
            } else {
                front = front.next;
                rear = rear.next;
            }
        }

        return resultNode.next;
    }

    /**
     * 18.1 在 O(1) 时间内删除链表节点
     *
     * @param head
     * @param tobeDelete
     * @return
     */
    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        // 参数校验
        if (head == null || tobeDelete == null)
            return null;

        if (tobeDelete.next != null) {  // 不是尾节点情况
            ListNode nextNode = tobeDelete.next;
            tobeDelete.val = nextNode.val;
            tobeDelete.next = nextNode.next;
            nextNode.next = null;
        } else {    // 是尾节点情况
            if (head == tobeDelete) {
                head = null;
            } else {
                while (head.next != tobeDelete)
                    head = head.next;

                head.next = null;
            }
        }

        return head;
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
            prittDigit(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index] = (char) (i + '0');
            printlToMaxOfDigit(number, index + 1);
        }
    }

    private void prittDigit(char[] number) {
        int index = 0;
        while (number.length > index && number[index] == '0')
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
     * 贪心算法实现
     *
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
        if (threshold <= 0 || rows <= 0 || cols <= 0)
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
        if (array == null || array.length == 0)
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

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);

        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * @param pre  前序遍历数组
     * @param preL 左索引
     * @param preR 右索引
     * @param inL  中序遍历的左侧
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

        TreeNode(int x) {
            val = x;
        }
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
     * <p>
     * 将一个字符串中的空格替换成 "%20"。
     * <p>
     * Input:
     * "A B"
     * <p>
     * Output:
     * "A%20B"
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
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
     * @param nums 数组
     * @param i    待交换元素
     * @param j    待交换元素
     */
    private void swap(int[] nums, int i, int j) {

    }
}
