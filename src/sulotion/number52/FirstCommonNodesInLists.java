package sulotion.number52;

/**
 * created by tianfeng on 2019/1/4
 * 面试题52：两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodesInLists {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node getCommonNode(Node node1,Node node2){
        int node1Len = getNodeLength(node1);
        int node2Len = getNodeLength(node2);
        int preMove = node2Len-node1Len;
        Node firstMove = node2;
        Node secondMove = node1;
        if (node1Len>node2Len){
            preMove = node1Len - node2Len;
            firstMove = node1;
            secondMove = node2;
        }
        for (int i = 0;i<preMove;i++){
            firstMove = firstMove.next;
        }
        int secontLength = getNodeLength(secondMove);
        for (int i=0;i<secontLength-1;i++){
            if (firstMove==secondMove){
                return firstMove;
            }
            firstMove = firstMove.next;
            secondMove = secondMove.next;
        }
        return null;
    }
    private static int getNodeLength(Node node){
        int count=0;
        while (node!=null){
            node = node.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.next = two;
        two.next = three;
        three.next = six;
        six.next = seven;
        four.next = five;
        five.next = six;
        System.out.println(getCommonNode(one,four).value);
    }
}
