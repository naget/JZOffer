package sulotion.number8;

/**
 * created by tianfeng on 2018/12/4
 */
public class FindNextNode {
    static class Node{
        char value;
        Node left;
        Node right;
        Node parent;
        public Node(char value){
            this.value = value;
        }
    }
    public static void printNextNodeValue(Node node){
        if (node.right!=null){//如果一个结点有右子树，那么它的下一个结点就是它的右子树中的最左子结点
            Node tem = node.right;
            node = node.right;
            while (node!=null){
                tem = node;
                node=node.left;
            }
            System.out.println(tem.value);
        }else if(node.parent!=null){
            Node parent = node.parent;
            if (parent.left == node){//如果结点是它父结点的左节点，那么它的下一个结点就是它的父结点
                System.out.println(parent.value);
            }else if (parent.right == node){//如果一个结点既没有右子树，并且还是其父结点的右结点，那么就沿着父结点路径
                Node parent1 = node.parent;//一直向上遍历，直到找到一个是它父结点的左节点的结点，如果存在，那么下个结点就是这个结点
                Node current = node;//的父结点，如果不存在，那么此结点不存在下一个结点，即这是最后一个结点
                while (parent1!=null&&parent1.right==node){
                    node = parent1;
                    parent1 = parent1.parent;
                }
                if (parent1!=null){
                    System.out.println(parent1.value);
                }else {
                    System.out.println("此节点是最后一个结点");
                }

            }
        }
    }

    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');
        Node h = new Node('h');
        Node i = new Node('i');
        a.left = b;
        a.right = c;
        b.parent = c.parent = a;
        b.left = d;
        b.right = e;
        d.parent = e.parent = b;
        e.left = h;
        e.right = i;
        h.parent = i.parent = e;
        c.left = f;
        c.right = g;
        f.parent = g.parent = c;
        printNextNodeValue(g);
    }
}
