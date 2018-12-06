package sulotion.number10;

/**
 * created by tianfeng on 2018/12/6
 * 斐波那契数列的递归实现，存在大量的重复计算（青蛙跳台阶、小矩阵覆盖大矩阵）
 */
public class FibonacciRec {
    public long fibonacc(long n){
        if (n==0)return 0;
        if (n==1)return 1;
        return fibonacc(n-1)+fibonacc(n-2);
    }
}
