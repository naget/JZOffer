package sulotion.number43;

/**
 * created by tianfeng on 2019/1/2
 * 面试题43：从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
 * 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 *
 * 基本就是跟着书敲的
 */
public class NumberOf1 {
    public static int numberOf1Between1AndN(int n){
        if (n<=0)return 0;
        String nString = String.valueOf(n);
        return numberOf1(nString,0);
    }
    private static int numberOf1(String n,int index){
        if (n==null||n.charAt(index)<'0'||n.charAt(index)>'9')return 0;
        int first = n.charAt(index)-'0';
        int length = n.length()-index;
        if (length==1&&first==0)return 0;
        if (length==1&&first>0)return 1;
        int numFirstDigit = 0;
        if (first>1)numFirstDigit = powerBase10(length-1);
        else if (first==1){
            int num = powerBase10(length-1);
            numFirstDigit = Integer.valueOf(n)%num+1;
        }
        int numOtherDigits = first*(length-1)*powerBase10(length-2);
        int numRecursive =numberOf1(n,index+1);
        return numFirstDigit+numOtherDigits+numRecursive;
    }
    private static int powerBase10(int n){
        int result = 1;
        for (int i = 0;i<n;i++){
            result*=10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1Between1AndN(12));
    }
}
