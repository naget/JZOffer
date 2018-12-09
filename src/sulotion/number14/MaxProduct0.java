package sulotion.number14;

/**
 * created by tianfeng on 2018/12/9
 * 面试题14：剪绳子
 * 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 *
 * 疑惑：1 为什么绳子长度不能是小数？ 2 贪婪算法最优解法的证明没看懂   （已经在github上提了issue）
 */
public class MaxProduct0 {
    //动态规划解法
    public static int maxProductAfterCut0(int n){
        if (n<2)return 0;
        if (n==2)return 1;
        if (n==3)return 2;
        int[] products = new int[n+1];
        products[0] =0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        //开始我觉得这里赋值错误，如果你也有这个错觉，可以移步https://github.com/zhedahht/CodingInterviewChinese2/issues/5
        for (int i=4;i<n;i++){
            int max = 0;
            for (int j=1;j<i/2;j++){
                if (max<products[i]*products[i-j]){
                    max = products[i]*products[i-j];
                }
            }
            products[i]=max;
        }
        return products[n];
    }
    //贪婪算法(为什么贪婪选择能得到最优解？数学方法证明)
    public int maxProductAfterCut(int n){
        if (n<2)return 0;
        if (n==2)return 1;
        if (n==3)return 2;
        int timeOfThree = n/3;
        if (n-3*timeOfThree*3==1){
            timeOfThree--;
        }
        int timeOfTwo = (n-timeOfThree*3)/2;
        return (int)Math.pow(3,timeOfThree)*(int)Math.pow(2,timeOfTwo);
    }
}
