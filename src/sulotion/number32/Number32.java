package sulotion.number32;

import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * created by tianfeng on 2018/11/5
 * 打印二叉树
 */
public class Number32 {
    private static BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
    private static Stack<TreeNode> stack = new Stack();
    private static Stack<TreeNode> otherStack = new Stack<>();
    private static Stack[] stacks = {stack,otherStack};
    static class TreeNode{
        public TreeNode(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        int value;
        TreeNode left;
        TreeNode right;
    }
    //从上到下按层打印(递归)
    public static void printLayerRecursion(TreeNode root) throws InterruptedException {
        System.out.print(root.value+" ");
        if (root.left!=null)queue.add(root.left);
        if (root.right!=null)queue.add(root.right);
        TreeNode treeNode = queue.poll();
        if (treeNode!=null)
        printLayerRecursion(treeNode);
    }
    //先序遍历（递归）
    public static void printBTPerRecursion(TreeNode root){
        if (root!=null){
            System.out.print(root.value+" ");
            printBTPerRecursion(root.left);
            printBTPerRecursion(root.right);
        }
    }
    //中序遍历（递归）
    public static void printBTMidRecursion(TreeNode root){
        if (root!=null){
            printBTMidRecursion(root.left);
            System.out.print(root.value+" ");
            printBTMidRecursion(root.right);
        }
    }
    //后序遍历(递归)
    public static void printBTBackRecursion(TreeNode root){
        if (root!=null){
            printBTBackRecursion(root.left);
            printBTBackRecursion(root.right);
            System.out.print(root.value+" ");
        }
    }
    //非递归先序遍历
    public static void printBTPerUnrecursion(TreeNode node){
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                System.out.print(node.value+" ");
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                node = node.right;
            }
        }
    }
    //非递归中序遍历
    public static void printBTMidUnrecursion(TreeNode node){
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                TreeNode node1 = stack.pop();
                System.out.print(node1.value+" ");
                node = node1.right;
            }
        }
    }
    //非递归后序遍历 参考自https://blog.csdn.net/zhuqiuhui/article/details/51319165
    public static void printBTBackUnrecursion(TreeNode node){
        if (node==null)return;
        TreeNode curNode;
        TreeNode lastVisitNode;
        curNode = node;
        lastVisitNode = null;
        //先找到最左节点
        while (curNode!=null){
            stack.push(curNode);
            curNode = curNode.left;
        }
        while (!stack.empty()){
            curNode = stack.pop();
            //如果此结点右节点不为空且没有被访问过，那么将它再次入栈，并顺着它的右节点再次入栈左节点
            if (curNode.right!=null&&curNode.right!=lastVisitNode){
                stack.push(curNode);
                curNode = curNode.right;
                while (curNode!=null){
                    stack.push(curNode);
                    curNode = curNode.left;
                }
            }else {
                System.out.print(curNode.value+" ");
                lastVisitNode = curNode;
            }
        }
    }
    //非递归按层遍历
    public static void printLayerUnrecursion(TreeNode node){
        if (node==null)return;
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            System.out.print(node1.value+" ");
            if (node1.left!=null)queue.add(node1.left);
            if (node1.right!= null)queue.add(node1.right);
        }
    }
    //之字遍历二叉树
    public static void printBTlikeZHI(TreeNode node){
        if (node==null)return;
        stack.push(node);
        int current = 0;
        int next = 1;
        while (!stack.empty()||!otherStack.isEmpty()){
            TreeNode node1 = (TreeNode) stacks[current].pop();
            System.out.print(node1.value+" ");
            if (current==0){
                if (node1.left!=null)stacks[next].push(node1.left);
                if(node1.right!=null)stacks[next].push(node1.right);

            }else {
                if (node1.right!=null)stacks[next].push(node1.right);
                if (node1.left!=null)stacks[next].push(node1.left);

            }
            if (stacks[current].empty()){
                current = 1-current;
                next = 1-next;
            }
        }
    }
    //测试用例
    public static void main(String[] args) throws InterruptedException {
        TreeNode eight = new TreeNode(8);
        TreeNode six = new TreeNode(6);
        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode seven = new TreeNode(7);
        TreeNode nine =  new TreeNode(9);
        TreeNode eleven = new TreeNode(11);
        eight.setLeft(six);
        eight.setRight(ten);
        six.setLeft(five);
        six.setRight(seven);
        ten.setLeft(nine);
        ten.setRight(eleven);

        System.out.println("先序遍历（递归）");
        printBTPerRecursion(eight);
        System.out.println();
        System.out.println("先序遍历（非递归）");
        printBTPerUnrecursion(eight);
        System.out.println();
        System.out.println("中序遍历（递归）");
        printBTMidRecursion(eight);
        System.out.println();
        System.out.println("中序遍历（非递归）");
        printBTMidUnrecursion(eight);
        System.out.println();
        System.out.println("后序遍历（递归）");
        printBTBackRecursion(eight);
        System.out.println();
        System.out.println("后序遍历（非递归）");
        printBTBackUnrecursion(eight);
        System.out.println();
        System.out.println("按层遍历（递归）");
        printLayerRecursion(eight);
        System.out.println();
        System.out.println("安层遍历（非递归）");
        printLayerUnrecursion(eight);
        System.out.println();
        System.out.println("之字遍历（非递归）");
        printBTlikeZHI(eight);
    }
}
