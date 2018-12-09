package sulotion.number13;

/**
 * created by tianfeng on 2018/12/9
 *
 * 面试题13：机器人的运动范围
 *
 * 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class MovingCount {
    public static int count(int k,int rows,int cols){
        int count;
        boolean[][] visit = new boolean[rows][cols];
        count = countCore(k,0,0,rows,cols,visit);
        return count;
    }
    private static int countCore(int k,int row,int col,int rows,int cols,boolean[][] visit){
        int count=0;
        if (row>=0&&row<rows&&col>=0&&col<cols&&!visit[row][col]){
            if (ifCanMove(k,row,col,rows,cols,visit)){
                count++;
            }
            count +=countCore(k,row-1,col,rows,cols,visit);
            count +=countCore(k,row+1,col,rows,cols,visit);
            count +=countCore(k,row,col-1,rows,cols,visit);
            count +=countCore(k,row,col+1,rows,cols,visit);

        }
        return count;
    }
    private static boolean ifCanMove(int k,int row,int col,int rows,int cols,boolean[][] visit){
        visit[row][col] = true;
        int sum = getDigitSum(row)+getDigitSum(col);
        return sum <= k;

    }
    private static int getDigitSum(int number){//得到各个数位之和
        int sum = 0;
        while (number>0){
            sum +=number%10;
            number/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(MovingCount.count(7,6,6));
    }
}
