package sulotion.number64;



/**
 * created by tianfeng on 2019/1/7
 * 面试题64：求1+2+…+n
 * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 *
 * 利用构造函数求解，实现递归
 */
public class Accumulate {
    private static int n=0;
    private static int Sum=0;
    public Accumulate(int N){
        if (N>n){
            n++;
            Sum += n;
           new Accumulate(N);
        }else System.out.println("1到n相加等于"+Sum);
    }

    public static void main(String[] args) {
        new Accumulate(100);
    }
}
