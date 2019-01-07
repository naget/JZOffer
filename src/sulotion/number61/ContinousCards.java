package sulotion.number61;

import java.util.Arrays;

/**
 * created by tianfeng on 2019/1/7
 * 面试题61：扑克牌的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
public class ContinousCards {
    public static boolean isContinous(int[] numbers){
        if (numbers.length<1)return false;
        Arrays.sort(numbers);
        int numberOfZero=0;
        int gap = 0;
        for (int i = 0;i<numbers.length;i++){
            if (numbers[i]==0){
                numberOfZero++;
                continue;
            }
            if (i+1<numbers.length&&(numbers[i+1]-numbers[i]>1)){
                gap +=numbers[i+1]-numbers[i]-1;
            }
            if (i+1>numbers.length&&(numbers[i+1]==numbers[i]))return false;
        }
        return numberOfZero>=gap;

    }

    public static void main(String[] args) {
        int[] numbers = {0,3,5,4,1};
        System.out.println(isContinous(numbers));
    }
}