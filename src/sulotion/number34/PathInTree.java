package sulotion.number34;


import java.util.Stack;

/**
 * created by tianfeng on 2018/12/30
 * 面试题34：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static void printPath(TreeNode root,int sum){
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        printPathCore(root,0,sum,stack);

    }
    private static void printPathCore(TreeNode node, int currentSum , int sum, Stack<Integer> stack){
        currentSum = currentSum+node.value;
        stack.push(node.value);
        if (node.left==null&&node.right==null&&currentSum==sum){
            print(stack);
        }
        if (node.left!=null){
            printPathCore(node.left,currentSum,sum,stack);
        }
        if (node.right!=null){
            printPathCore(node.right,currentSum,sum,stack);
        }
        stack.pop();

    }
    private static void print(Stack<Integer> stack){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = (Stack<Integer>) stack.clone();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        System.out.print("找到一个路径：");
        while (!stack1.isEmpty()){
            System.out.print(stack1.pop()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode ten  = new TreeNode(10);
        TreeNode five  = new TreeNode(5);
        TreeNode four  = new TreeNode(4);
        TreeNode seven  = new TreeNode(7);
        TreeNode twelve  = new TreeNode(12);
        ten.left = five;
        five.left = four;
        five.right = seven;
        ten.right = twelve;
        PathInTree.printPath(ten,22);
    }
}
