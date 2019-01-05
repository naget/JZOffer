package sulotion.number55;

/**
 * created by tianfeng on 2019/1/5
 * 面试题55（一）：二叉树的深度
 * 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
 * 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static int getDepth(TreeNode root){
        if (root == null)return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return left>right?left+1:right+1;
    }
}
