package sulotion.number49;

/**
 * created by tianfeng on 2019/1/3
 * 面试题49：丑数
 * 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
 * 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做第一个丑数。
 */
public class UglyNumber {
    public static int getUglyNumberAt_solution1(int index){
        int count = 0;
        int number = 0;
        while (count<index){
            number++;
            if (isUglyNumber(number))count++;
        }
        return number;
    }
    private static boolean isUglyNumber(int number){
        while (number%2==0)number /=2;
        while (number%3==0)number /=3;
        while (number%5==0)number /=5;
        return number == 1;
    }

    public static int getUglyNumberAt_sulution2(int index){
        if (index<=0)return 0;
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyIndex = 1;
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;
        while (nextUglyIndex<index){
            int min = min(uglyNumbers[multiply2]*2,uglyNumbers[multiply3]*3,uglyNumbers[multiply5]*5);
            uglyNumbers[nextUglyIndex] = min;
            while (uglyNumbers[multiply2]*2<=uglyNumbers[nextUglyIndex])multiply2++;
            while (uglyNumbers[multiply3]*3<=uglyNumbers[nextUglyIndex])multiply3++;
            while (uglyNumbers[multiply5]*5<=uglyNumbers[nextUglyIndex])multiply5++;
            nextUglyIndex++;
        }
        int ugly = uglyNumbers[nextUglyIndex-1];
        return ugly;
    }
    private static int min(int a,int b,int c){
        int min = a>b?b:a;
        return min<c?min:c;
    }

    public static void main(String[] args) {

        System.out.println(getUglyNumberAt_solution1(1500));
        System.out.println("=================================");
        System.out.println(getUglyNumberAt_sulution2(1500));
    }
}
