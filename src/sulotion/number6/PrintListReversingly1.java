package sulotion.number6;

import java.util.Stack;

/**
 * created by tianfeng on 2018/11/24
 * 倒序打印链表——使用栈
 */
public class PrintListReversingly1 {
    static class LinkedNode{
         int id;
         LinkedNode next;
         public LinkedNode(int id){
             this.id = id;
         }
    }
    public static void print(LinkedNode node){
        Stack<LinkedNode> stack = new Stack<>();
        while (node!=null){
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().id+" ");
        }
    }

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1);
        LinkedNode node1 = new LinkedNode(2);
        LinkedNode node2 = new LinkedNode(3);
        node.next = node1;
        node1.next = node2;
        System.out.println("使用栈倒序打印链表：");
        PrintListReversingly1.print(node);
        System.out.println();
        System.out.println("使用递归倒序打印链表：");
        PrintListReversingly2.print(node);
    }
}
