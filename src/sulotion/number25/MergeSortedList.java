package sulotion.number25;

/**
 * created by tianfeng on 2018/12/27
 * 面试题25：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按
 * 照递增排序的。例如输入图3.11中的链表1和链表2，则合并之后的升序链表如链
 * 表3所示。
 */
public class MergeSortedList {
    static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    //非递归合并
    public static Node merge(Node head1,Node head2){
        if (head1==null){
            return head2;
        }else if (head2==null){
            return head1;
        }
        Node newListHead = null;
        if (head1.value>head2.value){
            newListHead = head2;
            head2 = head2.next;
        }else {
            newListHead = head1;
            head1 = head1.next;
        }
        Node node = newListHead;
        while (head1!=null||head2!=null){
            if (head1==null){
                node.next = head2;
                node = node.next;
                head2 = head2.next;
            }else if (head2==null){
                node.next = head1;
                node = node.next;
                head1 = head1.next;
            }else if(head1.value>head2.value){
                node.next = head2;
                node = node.next;
                head2 = head2.next;
            }else {
                node.next = head1;
                node = node.next;
                head1 = head1.next;
            }
        }
        return newListHead;
    }
    //递归合并
    public static Node mergeRec(Node head1,Node head2){
        if (head1==null){
            return head2;
        }else if (head2==null){
            return head1;
        }
        Node newHead = null;
        if (head1.value>head2.value){
            newHead = head2;
            newHead.next = mergeRec(head1,head2.next);
        }else {
            newHead = head1;
            newHead.next = mergeRec(head1.next,head2);
        }
        return newHead;
    }
    public static void print(Node head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two1 = new Node(2);
        Node two2 = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        one.next = two1;
        two1.next = four;
        four.next = six;
        two2.next = three;
        three.next = five;
        //非递归合并链表 1-2-4-6和2-3-5
        Node head = MergeSortedList.merge(one,two2);
        System.out.println("非递归合并结果：");
        print(head);

    }
}
