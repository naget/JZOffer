package sulotion.number12;

/**
 * created by tianfeng on 2018/12/8
 * 面试题12：矩阵中的路径
 * 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * A B T G
 * C F C S
 * J D E H
 */
public class HasPathDemo {
    public static boolean hashPath(char[][] chars,String s){
        int row = chars.length;
        int col = chars[0].length;
        int sLen = s.length();
        int sIndex = 0;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0;i<row;i++){
            for (int j = 0;j<col;j++){
                if (hashPathCore(chars,i,j,visit,0,sLen,s)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hashPathCore(char[][] chars,int row,int col,boolean[][] visit,int index,int sLen,String s){
        if (index==sLen){
            return true;
        }
        if (row>=0&&col>=0&&row<chars.length&&col<chars[0].length&&!visit[row][col]){
            visit[row][col]=true;
            boolean hasPath = false;
            if (chars[row][col]==s.charAt(index)){
                hasPath = hashPathCore(chars,row-1,col,visit,index+1,sLen,s)||
                        hashPathCore(chars,row+1,col,visit,index+1,sLen,s)||
                        hashPathCore(chars,row,col+1,visit,index+1,sLen,s)||
                        hashPathCore(chars,row,col-1,visit,index+1,sLen,s);
                return hasPath;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        System.out.println(HasPathDemo.hashPath(chars,"abfcedd"));
    }
}
