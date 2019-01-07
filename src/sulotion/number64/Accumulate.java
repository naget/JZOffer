package sulotion.number64;



/**
 * created by tianfeng on 2019/1/7
 * 面试题64：求1+2+…+n
 * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 *
 * 短路求值
 */
public class Accumulate {
    private static int n=0;
    private static int Sum=0;
    public static int getSum(int n){
        int result = 0;
        result = n;
        boolean value = (n!=0)&&1==(result += getSum(n-1));
        return result;
    }
    public static void main(String[] args) {
        System.out.println(getSum(100));
    }
}
