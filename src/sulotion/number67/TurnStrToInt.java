package sulotion.number67;


/**
 * created by tianfeng on 2019/1/7
 * 面试题67：把字符串转换成整数
 * 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 * 能使用atoi或者其他类似的库函数。
 */
public class TurnStrToInt {
    public static long stringToInt(String s) throws Exception{
        if (s==null)throw new Exception("非法输入");
        boolean minus = false;
        long sum = 0;
        int length = s.length();
        double base = Math.pow(10,length-1);
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (c=='+'){
                base = base/10;
                continue;
            }
            else if (c=='-'){
                minus = true;
                base = base/10;
                continue;
            }
            else if ((c<'0'||c>'9'))throw new Exception("非法输入");
            else {
                int number = c-'0';
                sum += number*base;
                if (!minus&&sum>Integer.MAX_VALUE||minus&&-sum<Integer.MIN_VALUE)throw new Exception("非法输入");
                base = base/10;
            }

        }
        if (minus)sum = -sum;
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(stringToInt("-88123"));
    }
}
