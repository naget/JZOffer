package sulotion.number37;

import java.util.LinkedList;

/**
 * created by tianfeng on 2018/12/31
 * 面试题37：序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeBT {
    static class Node{
        char value;
        Node left;
        Node right;
        public Node(char value){
            this.value = value;
        }
    }
    //序列化二叉树，null用'$'替代
    public static void serialize(Node root, LinkedList<Character> stream){
        if (root==null){
            stream.add('$');
            return;
        }
        stream.add(root.value);
        serialize(root.left,stream);
        serialize(root.right,stream);
    }
    //反序列化二叉树
    public static Node deSerialize(LinkedList<Character> stream){
        if (stream.isEmpty())return null;
        char value = stream.remove();
        Node node = null;
        if (value!='$'){
            node = new Node(value);
        }
        if (node!=null){
            node.left = deSerialize(stream);
            node.right = deSerialize(stream);
        }
        return node;
    }

    public static void main(String[] args) {
        Node one = new Node('1');
        Node two = new Node('2');
        Node three = new Node('3');
        Node four = new Node('4');
        Node five = new Node('5');
        Node six = new Node('6');
        one.left = two;
        two.left = four;
        one.right = three;
        three.left = five;
        three.right = six;
        LinkedList<Character> stream = new LinkedList<>();
        SerializeBT.serialize(one,stream);
        for (char value :
                stream) {
            System.out.print(value+" ");
        }
        System.out.println();
        Node newOne = SerializeBT.deSerialize(stream);//newOne是反序列化得到的二叉树的根节点
        System.out.println();
    }
}
