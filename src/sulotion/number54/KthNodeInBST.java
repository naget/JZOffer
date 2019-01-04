package sulotion.number54;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * created by tianfeng on 2019/1/4
 * 面试题54：二叉搜索树的第k个结点
 * 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 */
public class KthNodeInBST {
    static int kScore;
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static void getKthNode(TreeNode root,int k){
        kScore = k;
        getKthNode(root);
    }
    public static void getKthNode(TreeNode root){
        if (root!=null){
            getKthNode(root.left);
            kScore--;
            if (kScore==0) System.out.println(root.value);
            getKthNode(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        five.left = three;
        three.left = two;
        three.right = four;
        five.right = seven;
        seven.left = six;
        seven.right = eight;
        getKthNode(five,3);
    }
}
