package sulotion.number56;


/**
 * created by tianfeng on 2019/1/5
 * 面试题56（二）：数组中唯一只出现一次的数字
 * 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
 * 找出那个只出现一次的数字。
 */
public class TheNumberAppearOnec {
    public static void getNumber(int[] data){//思路和书上是一样的，但代码实现不一样
        int targetBitIndex = 0;
        while (targetBitIndex<32){
            int sum=0;
            for (int i = 0;i<data.length;i++){
                sum += (data[i]>>targetBitIndex)&1;
            }
            if (sum!=0&&sum%3==0)break;//所有数字不可能都是0，不然不符合提议，所以一定可以找到sum不为零的情况
            //此时，不重复的数对应的这个位一定是0
            targetBitIndex++;
        }
        for (int i = 0;i<data.length;i++){
            if (((data[i]>>targetBitIndex)&1)==0){
                System.out.println("不重复的数字是："+data[i]);
                break;
            }
        }

    }

    public static void main(String[] args) {
        int[] numbers = {1,3,3,3,6,6,6,9,9,9,88,88,88};
        getNumber(numbers);
    }


}
