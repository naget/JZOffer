package sulotion.number27;

/**
 * created by tianfeng on 2018/12/27
 * 面试题27：二叉树的镜像
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorOfBinaryTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode getMirror(TreeNode root){
        if (root==null)return null;
        TreeNode left = root.left;
        TreeNode rigth = root.right;
        root.left = getMirror(rigth);
        root.right = getMirror(left);
        return rigth;
    }
}
