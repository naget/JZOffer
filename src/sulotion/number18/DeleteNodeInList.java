package sulotion.number18;

/**
 * created by tianfeng on 2018/12/24
 *
 * 面试题18（一）：在O(1)时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该
 * 结点。
 */
public class DeleteNodeInList {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public static void deleteNode(Node head,Node deleteNode){
        if (head==deleteNode){
            if (deleteNode.next!=null){
                Node next = deleteNode.next;
                deleteNode.value = next.value;
                deleteNode.next = next.next;
                next = null;
            }else {
                head = null;
            }
        }else {
            if (deleteNode.next!=null){
                Node next = deleteNode.next;
                deleteNode.value = next.value;
                deleteNode.next = next.next;
                next=null;
            }else {
                Node next = head.next;
                Node pretail=next;
                while (next!=deleteNode){
                    pretail = next;
                    next = next.next;
                }
                pretail.next = null;
            }
        }
    }

    public static void print(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        DeleteNodeInList.deleteNode(one,one);
        print(one);
    }
}
