package sulotion.number42;

/**
 * created by tianfeng on 2019/1/2
 * 面试题42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
public class GreatestSumOfSubarrays {
    public static int getGreatestSum(int[] numbers){
        int sum = 0;
        int greatestSum = 0;
        for (int i = 0;i<numbers.length;i++){
            if (sum<=0){
                sum = numbers[i];
            }else {
                sum +=numbers[i];
            }
            if (greatestSum<sum)greatestSum = sum;

        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] numbers = {1,-2,3,10,-4,7,2,-5};
        System.out.println("连续子数组最大和是："+getGreatestSum(numbers));
    }
}
