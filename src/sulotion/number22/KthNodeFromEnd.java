package sulotion.number22;

/**
 * created by tianfeng on 2018/12/26
 * 面试题22：链表中倒数第k个结点
 * 题目：输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾结点是倒数第1个结点。例如一个链表有6个结点，
 * 从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是
 * 值为4的结点。
 *
 * --------------快慢指针-----------------
 */
public class KthNodeFromEnd {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node getKthNodeFromEnd(Node head,int k){
        if (head==null||k<=0){
            return null;
        }
        Node first = head;
        Node second = head;
        for (int i=0;i<k-1;i++){//保持first和second的距离是k-1，这样当second到达尾部时，first正好是倒数第k个
            if (first.next!=null){
                first = first.next;
            }else {
                return null;
            }
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
