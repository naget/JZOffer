package sulotion.number35;

import java.util.HashMap;

/**
 * created by tianfeng on 2018/12/30
 * 面试题35：复杂链表的复制
 * 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
 * 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
public class CloneComplexList {
    private static HashMap<Node,Node> map = new HashMap<>();
    static class Node{
        int value;
        Node next;
        Node Sibling;
        public Node(int value){
            this.value = value;
        }
    }
    //暴力复制 时间复杂度n方
    public static Node forceClone(Node node){
        Node newHead = clone(node);
        Node node1 = newHead;
        Node node2 = node;
        while (node1!=null){
            Node tar = node2.Sibling;
            if (tar!=null){
                Node tem = newHead;
                while (tem!=null&&tem.value!=tar.value){
                    tem = tem.next;
                }
                node1.Sibling = tem;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return newHead;
    }
    //复制next链
    private static Node clone(Node head){
        if (head!=null){
            int value = head.value;
            Node node = new Node(value);
            node.next = clone(head.next);
            map.put(head,node);//服务于hashClone
            return node;
        }
        return null;
    }
    //空间换时间，用一个hashmap来使用O（1）的时间找到node的复制结点
    public static Node hashClone(Node node){
        Node newHead = clone(node);
        Node node1 = newHead;
        Node node2 = node;
        while (node1!=null){
            node1.Sibling = map.get(node2.Sibling);
            node1 = node1.next;
            node2 = node2.next;
        }
        return newHead;
    }
    //书上的那种三步走战略,秒啊
    public static Node newClone(Node node){
        cloneNodes(node);
        connectSlibingNodes(node);
        return slipTheClone(node);
    }
    private static void cloneNodes(Node head){
        Node node = head;
        while (node!=null){
            int value = node.value;
            Node nodeCopy = new Node(value);
            Node next = node.next;
            node.next = nodeCopy;
            nodeCopy.next = next;
            node = next;
        }
    }
    //连接复制链表的sibling
    private static void connectSlibingNodes(Node head){
        Node node = head;
        while (node!=null){
            if (node.Sibling!=null){
                node.next.Sibling = node.Sibling.next;
            }
            if (node.next!=null){
                node = node.next.next;
            }

        }
    }
    //将原链表和复制链表拆开，并返回复制链表的头结点
    private static Node slipTheClone(Node head){
        Node node = head;
        Node cloneHead = null;
        Node cloneNode = null;
        if (node!=null){
            cloneHead = cloneNode =node.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node!=null){
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

    public static void print(Node node){
        while (node!=null){
            System.out.print(node.value);
            if (node.next!=null){
                System.out.print("的next是"+node.next.value);
            }
            if (node.Sibling!=null){
                System.out.println(",sibling是"+node.Sibling.value);
            }
            System.out.println();
            node = node.next;
        }
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        one.next = two;
        one.Sibling = three;
        two.next = three;
        two.Sibling = five;
        three.next = four;
        four.next = five;
        four.Sibling = two;
        Node forceClone = CloneComplexList.forceClone(one);
        Node hashClone = CloneComplexList.hashClone(one);
        Node newClone = CloneComplexList.newClone(one);
        System.out.println("============原链表结构===============：");
        print(one);
        System.out.println("===========暴力复制结果==============：");
        print(forceClone);
        System.out.println("==============hash复制结果============：");
        print(hashClone);
        System.out.println("==============三步法复制结果===========：");
        print(newClone);
    }
}
