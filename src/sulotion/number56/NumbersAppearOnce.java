package sulotion.number56;


/**
 * created by tianfeng on 2019/1/5
 * 面试题56（一）：数组中只出现一次的两个数字
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * A^0=A       A^A=0
 */
public class NumbersAppearOnce {
    public static void findNumbersAppearOnec(int[] data){
        int resultExclusiveOR = 0;
        for (int i = 0;i<data.length;i++){
            resultExclusiveOR ^=data[i];
        }
        int firstBitIs1Index = findFirstBit0f1(resultExclusiveOR);
        int one=0;
        int two=0;
        for (int i = 0;i<data.length;i++){
            if (isBit1(data[i],firstBitIs1Index))one ^=data[i];
            else two ^=data[i];
        }
        System.out.println("两个出现一次的数是："+one+" "+two);
    }
    private static int findFirstBit0f1(int number){
        int index = 0;
        while (index<32){
            if ((number&1)==1)break;
            number = number>>>1;
            index++;
        }
        if (index<32){
            return index;
        }
        return -1;
    }
    private static boolean isBit1(int number,int indexBit){
        number = number>>indexBit;
        return (number&1)==1;
    }

    public static void main(String[] args) {
        int[] numbers = {2,4,3,6,3,2,5,5};
        findNumbersAppearOnec(numbers);
    }
}
