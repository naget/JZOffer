package sulotion.number7;

import sulotion.number32.Number32;

/**
 * created by tianfeng on 2018/12/3
 * 面试题7：重建二叉树
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,
 * 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * 图2.6所示的二叉树并输出它的头结点。
 */
public class RebuildBT {
    static class TreeNode{
        int value;
        TreeNode leftChild;
        TreeNode rightChild;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode rebuild(int[] preSort,int[] midSort) throws Exception {
        return rebuild(preSort,midSort,0,preSort.length-1,0,midSort.length-1);
    }
    private static TreeNode rebuild(int[] preSort,int[] midSort,int startPreOrder,int endPreOrder,int startMidOrder,int endMidOrder) throws Exception {
        TreeNode root = new TreeNode(preSort[startPreOrder]);
        if (startPreOrder==endPreOrder){
            if (startMidOrder==endMidOrder){
                return root;
            }else {
                throw new Exception("序列不合法");
            }
        }
        int rootIndex = startMidOrder;
        while (rootIndex<=endMidOrder&&midSort[rootIndex]!=root.value)rootIndex++;//找到根节点在中序遍历中的位置
        if (rootIndex==endMidOrder&&midSort[rootIndex]!=root.value){
            throw new Exception("序列不合法");
        }

        int leftLength = rootIndex-startMidOrder;//左子树的长度
        int leftPreEnd = startPreOrder+leftLength;//先序遍历数组中左子树结束的位置
        //构建左子树
        if (leftLength>0){
            root.leftChild = rebuild(preSort,midSort,startPreOrder+1,leftPreEnd,startMidOrder,rootIndex-1);
        }
        //构建右子树
        if (leftLength<endPreOrder-startPreOrder){
            root.rightChild = rebuild(preSort,midSort,leftPreEnd+1,endPreOrder,rootIndex+1,endMidOrder);
        }
        return root;
    }
    public static void print(TreeNode node){
        if (node!=null){
            print(node.leftChild);
            print(node.rightChild);
            System.out.print(node.value+" ");
        }
    }

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] midOrder = {4,7,2,1,5,3,8,6};
        try {
            TreeNode root = RebuildBT.rebuild(preOrder,midOrder);
            print(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
