package sulotion.number26;

/**
 * created by tianfeng on 2018/12/27
 * 面试题26：树的子结构
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
public class SubStructureInTree {
    static class TreeNode{
        double value;
        TreeNode left;
        TreeNode right;
        public TreeNode(double value){
            this.value = value;
        }
    }

    public static boolean isSub(TreeNode A,TreeNode B){
        boolean result = false;
        if (A!=null&&B!=null){
            if (equal(A,B)){
                result = doseAhaveB(A,B);
            }
            if (!result)result = isSub(A.left,B);
            if (!result)result = isSub(A.right,B);
        }
        return result;
    }
    public static boolean doseAhaveB(TreeNode treeNode1,TreeNode treeNode2){
        if (treeNode2==null)return true;
        if (treeNode1==null)return false;
        if (!equal(treeNode1,treeNode2))return false;
        return doseAhaveB(treeNode1.left,treeNode2.left)&&doseAhaveB(treeNode1.right,treeNode2.right);
    }
    public static boolean equal(TreeNode treeNode1,TreeNode treeNode2){
        if (treeNode1.value-treeNode2.value>-0.0000001&&treeNode2.value-treeNode1.value<0.0000001){
            return true;
        }else return false;
    }
}
