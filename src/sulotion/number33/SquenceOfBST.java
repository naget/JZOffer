package sulotion.number33;

/**
 * created by tianfeng on 2018/12/30
 * 面试题33：二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class SquenceOfBST {
    public static boolean verifySequence(int[] sequence){
        return verifySequenceCore(sequence,0,sequence.length-1);
    }
    private static boolean verifySequenceCore(int[] sequence,int start,int end){
        int root = sequence[end];
        int i = start;
        for (;i<=end;i++){//如此实在巧妙，我本来还定义了leftLen和rightLen，哈哈
            if (sequence[i]>root){
                break;
            }
        }
        int j = i;
        for (;j<=end;j++){
            if (sequence[j]<root)return false;
        }
        boolean left=true;
        boolean right=true;//left和right初始化为true，是为了当没有左子树或右子树时，仍能返回正常的结果（left&&right）
        if (i>start)left = verifySequenceCore(sequence,start,i-1);
        if (i<end)right = verifySequenceCore(sequence,i,end);
        return left&&right;
    }
}
