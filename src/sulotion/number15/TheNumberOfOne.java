package sulotion.number15;

/**
 * created by tianfeng on 2018/12/19
 * 面试题15：二进制中1的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 *
 * 小tip:把一个整数减去1之后再和原来的数做位与运算，得到的结果相当于把整数的二进制表示中最右边的1变成0。
 */
public class TheNumberOfOne {

    //方法一：循环32次
    public static int theNumberOf1_A(int n){
        int count=0;
        int flag = 1;
        while (flag!=0){
            if ((flag&n)!=0)count++;
            flag=flag<<1;
        }
        return count;
    }

    //方法二：有多少1，循环多少次
    public static int theNumberOf1_B(int n){
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

}
