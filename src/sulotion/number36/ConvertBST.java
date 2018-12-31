package sulotion.number36;


/**
 * created by tianfeng on 2018/12/30
 * 面试题36：二叉搜索树与双向链表
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBST {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node convert(Node root){
        Node lastNodeInList = null;
        convertCore(root,lastNodeInList);
        Node node = root;
        if (node!=null){
            node = node.left;
        }
        return node;
    }
    private static Node convertCore(Node node,Node lastNodeInList){//返回值是链表的最后一个结点（书中代码没有返回值，但使用了指针的指针，相当于可以随时获取链表的最后一个结点）
        if (node==null)return null;
        Node current = node;
        if (current.left!=null)
            lastNodeInList=convertCore(current.left,lastNodeInList);
        current.left = lastNodeInList;
        if (lastNodeInList!=null){
            lastNodeInList.right = current;
        }
        lastNodeInList = current;
        if (current.right!=null){
            lastNodeInList=convertCore(current.right,lastNodeInList);
        }
        return lastNodeInList;
    }

    public static void main(String[] args) {
        Node ten = new Node(10);
        Node six = new Node(6);
        Node four = new Node(4);
        Node eight = new Node(8);
        Node fourteen = new Node(14);
        Node twelve = new Node(12);
        Node sixteen = new Node(16);
        ten.left = six;
        ten.right = fourteen;
        six.left = four;
        six.right = eight;
        fourteen.left = twelve;
        fourteen.right = sixteen;
        ConvertBST.convert(ten);
        System.out.println();
    }
}
