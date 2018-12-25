package sulotion.number18;


/**
 * created by tianfeng on 2018/12/24
 * 面试题18（二）：删除链表中重复的结点
 * 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * 结点被删除之后，链表如图3.4（b）所示。
 */
public class DeleteDuplicatedNode {
    public static void delete(DeleteNodeInList.Node head){
        DeleteNodeInList.Node preNode = null;
        DeleteNodeInList.Node node = head;
        while (node!=null){
            DeleteNodeInList.Node next = node.next;
            boolean needDedlete = false;
            if (next!=null&&next.value==node.value)needDedlete=true;
            if (!needDedlete){
                preNode = node;
                node = next;
            }else {
                int value = node.value;
                DeleteNodeInList.Node preToBeDelete = node;
                while (preToBeDelete!=null&&preToBeDelete.value==value){
                    next = preToBeDelete.next;
                    preToBeDelete = next;
                }
                if (preNode ==null){
                    head = next;
                }else {
                    preNode.next = next;
                }
                node = next;
            }
        }
    }
}
