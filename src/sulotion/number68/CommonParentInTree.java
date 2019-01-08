package sulotion.number68;


import java.util.Stack;

/**
 * created by tianfeng on 2019/1/7
 * 面试题68：树中两个结点的最低公共祖先
 * 题目：输入两个树结点，求它们的最低公共祖先。
 *
 * 这里用的是二叉树，道理是一样的，多叉树是需要遍历每个子树就可以了，这里二叉树就是只遍历了左右子树
 */
public class CommonParentInTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode getCommonParent(TreeNode root,TreeNode child1,TreeNode child2){
        return getCommonNode(root,child1,child2);
    }
    private static boolean getPath(TreeNode root, TreeNode target, Stack<TreeNode> path){
        if (root == target) return true;
        path.push(root);
        boolean found = false;
        boolean end = false;
        while (!found&&!end){
            if (root.left!=null)found=getPath(root.left,target,path);
            if (!found&&root.right!=null)found = getPath(root.right,target,path);
            end = true;//此结点左右子树中都没有找到目标结点，于是退出循环，弹出此结点
        }
        if (!found)path.pop();
        return found;
    }

    private static TreeNode getCommonNode(TreeNode root,TreeNode node1,TreeNode node2){
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> path2 = new Stack<>();
        if (getPath(root,node1,path1)&&getPath(root,node2,path2)){
            int length1 = path1.size();
            int length2 = path2.size();
            int preStep = 0;
            Stack<TreeNode> first = path1;
            Stack<TreeNode> second = path2;
            preStep = length1-length2;
            if (length2>length1){
                first = path2;
                second = path1;
                preStep = length2-length1;
            }
            for (int i = 0;i<preStep;i++){
                first.pop();
            }
            while (!path1.isEmpty()&&!path2.isEmpty()){
                TreeNode temp1=first.pop();
                TreeNode temp2=second.pop();
                if (temp1==temp2){
                    return temp1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        one.left = two;
        two.left = four;
        four.left = six;
        four.right = seven;
        two.right = five;
        five.left = eight;
        five.right = nine;
        one.right = three;
        System.out.println(getCommonParent(one,six,nine).value);
    }
}
