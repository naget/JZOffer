package sulotion.number23;

/**
 * created by tianfeng on 2018/12/26
 * 面试题23：链表中环的入口结点
 * 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * 环的入口结点是结点3。
 *
 * 通过快慢指针找到环中节点，用环中节点计算出环中节点个数N，然后初始化快慢指针为头结点，快指针先走N步，然后同速
 * 前进，会在环的入口处相遇。
 */
public class EntryNodeInListLoop {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static Node getEntryNodeOfListLoop(Node head){
        Node meetNode = getMeetNode(head);
        if (meetNode==null){
            return null;
        }
        int LoopNodes = 2;
        Node node = meetNode.next;
        while (node!=meetNode){
            LoopNodes++;
            node = node.next;
        }
        Node fast = head;
        Node slow = head;
        for (int i=0;i<LoopNodes;i++){
            fast = fast.next;
        }
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    private static Node getMeetNode(Node head){
        if (head==null){
            return null;
        }
        Node slow = head;
        if (slow.next==null){
            return null;
        }
        Node fast = slow.next;
        while ((fast!=null)&&(slow!=null)){
            if (fast==slow){
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast!=null){
                fast = fast.next;
            }
        }
        return null;

    }
}
