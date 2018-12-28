package sulotion.number28;

import jdk.nashorn.internal.ir.ThrowNode;

/**
 * created by tianfeng on 2018/12/28
 * 面试题28：对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * 它的镜像一样，那么它是对称的。
 *
 * 通过比较二叉树的前序遍历序列和对称前序遍历序列来判断二叉树是不是对称的
 */
public class SymmetricalBinaryTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static boolean isSymmetrical(TreeNode treeNode){
        return isSymmetrical(treeNode,treeNode);
    }
    private static boolean isSymmetrical(TreeNode treeNode1,TreeNode treeNode2){
        if (treeNode1==null&&treeNode2==null)return true;
        if (treeNode1==null||treeNode2==null)return false;
        if (treeNode1.value!=treeNode2.value)return false;
        return isSymmetrical(treeNode1.left,treeNode2.right)&&isSymmetrical(treeNode1.right,treeNode2.left);
    }
}
