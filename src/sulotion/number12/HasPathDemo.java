package sulotion.number12;

/**
 * created by tianfeng on 2018/12/8
 * 矩阵中的路径
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
