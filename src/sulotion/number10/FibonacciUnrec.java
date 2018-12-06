package sulotion.number10;

/**
 * created by tianfeng on 2018/12/6
 * 利用循环来解决斐波那契数列问题（青蛙跳台阶、小矩阵覆盖大矩阵）
 */
public class FibonacciUnrec {
    public static long fibonacci(long n){
       if (n==0)return 0;
       if (n==1)return 1;
       long one = 0;
       long two = 1;
       long N = 0;
       for (int i=2;i<=n;i++){
           N = one+two;
           one = two;
           two = N;
       }
       return N;
    }
}
