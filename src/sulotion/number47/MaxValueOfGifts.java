package sulotion.number47;

/**
 * created by tianfeng on 2019/1/3
 * 面试题47：礼物的最大价值
 * 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
 * （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
 * 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
 * 算你最多能拿到多少价值的礼物？
 */
public class MaxValueOfGifts {
    public static int getMaxValue_solution1(int[][] arrays){
        int rows = arrays.length;
        int cols = arrays[0].length;
        int[][] maxValue = new int[rows][cols];
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<cols;j++){
                int maxi=0;
                int maxj = 0;
                if (i>0){
                    maxi = maxValue[i-1][j];
                }
                if (j>0){
                    maxj = maxValue[i][j-1];
                }
                maxValue[i][j] = Math.max(maxi,maxj)+arrays[i][j];

            }
        }
        int maxResult = maxValue[rows-1][cols-1];
        return maxResult;
    }
}
