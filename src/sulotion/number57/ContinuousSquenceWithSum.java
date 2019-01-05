package sulotion.number57;

/**
 * created by tianfeng on 2019/1/5
 * 面试题57（二）：为s的连续正数序列
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * 4～6和7～8。
 */
public class ContinuousSquenceWithSum {
    public static void printContinuousSquence(int sum){//思路跟书上一样，代码有所差别
        if (sum<3)return;
        int small = 1;
        int big = 2;
        int curSum = 3;
        while (small<(sum+1)/2){
            if (curSum<sum){
                big++;
                curSum +=big;
            }else if (curSum>sum){
                curSum -=small;
                small++;
            }else {
                printSquence(small,big);
                big++;
                curSum +=big;
            }
        }
    }
    private static void printSquence(int small,int big){
        for (int i=small;i<=big;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printContinuousSquence(15);
    }
}
