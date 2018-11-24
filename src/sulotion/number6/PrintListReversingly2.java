package sulotion.number6;

/**
 * created by tianfeng on 2018/11/24
 * 倒序打印链表——使用递归
 */
public class PrintListReversingly2 {
    public static void print(PrintListReversingly1.LinkedNode node){
        if (node==null)return;
        if (node.next!=null){
            print(node.next);
        }
        System.out.print(node.id+" ");
    }
}
