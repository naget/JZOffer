package sulotion.number29;

/**
 * created by tianfeng on 2018/12/28
 * 面试题29：顺时针打印矩阵
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class PrintMatrix {
    public static void print(int[][] matrix,int rows,int cols){
        if (matrix==null||rows<1||cols<1)return;
        int start = 0;
        while (cols>2*start&&rows>start*2){
            printCircle(matrix,rows,cols,start);
            start++;
        }
    }
    private static void printCircle(int[][] matrix,int rows,int cols,int start){
        int endX = cols-1-start;
        int endY = rows-1-start;
        for (int i = start;i<endX;i++){
            System.out.print(matrix[start][i]+" ");
        }
        if (start<endY){
            for (int i = start;i<endY;i++){
                System.out.print(matrix[i][endX]);
            }
        }
        if (start<endX&&start<endY){
            for (int i=endX;i>=start;i--){
                System.out.print(matrix[endY][i]);
            }
        }
        if (start<endX&&start<endY-1){
            for (int i = endY;i>start;i--){
                System.out.print(matrix[start][i]);
            }
        }

    }
}
