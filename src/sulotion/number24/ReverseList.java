package sulotion.number24;

/**
 * created by tianfeng on 2018/12/26
 * 面试题24：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
 *
 * 记录下前一个节点、当前节点、下一个节点
 */
public class ReverseList {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node reverseList(Node head){
        Node pre = null;
        Node current = head;
        Node reverseHead = null;
        while (current!=null){
            if (current.next==null){
                reverseHead = current;
            }
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return reverseHead;
    }
}
