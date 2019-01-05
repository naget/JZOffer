package sulotion.number55;

/**
 * created by tianfeng on 2019/1/5
 * 面试题55（二）：平衡二叉树
 * 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
 * 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class BalancedBinaryTree {
    private static int depth;
    private static int left;
    private static int right;
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static boolean isBalance(TreeNode root){
        return isBalance(root,0);
    }
    private static boolean isBalance(TreeNode node,Integer depth){
        if (node==null){
            depth=0;
            return true;
        }
        Integer left = new Integer(-1);
        Integer right = new Integer(-1);
        if (isBalance(node.left,left)&&isBalance(node.right,right)){
            int diff = left-right;
            if (depth<=1||depth>=-1){
                depth = 1+left>right?left:right;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        two.left = three;
        three.left = five;
        three.right = six;
        six.left = eight;
        two.right = four;
        four.right = seven;
        System.out.println(isBalance(two));
    }
}
