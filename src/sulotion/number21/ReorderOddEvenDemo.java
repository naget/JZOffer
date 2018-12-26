package sulotion.number21;

/**
 * created by tianfeng on 2018/12/26
 *
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 */
public class ReorderOddEvenDemo {
    public static void reOrderArray(int[] array){
        int beginIndex = 0;
        int endIndex = array.length-1;
        while (beginIndex<endIndex){
            while ((array[beginIndex]&0x1)!=0)beginIndex++;
            while ((array[endIndex]&0x1)==0)endIndex--;
            if (beginIndex>=endIndex)break;
            int temp = array[beginIndex];
            array[beginIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }

    //可扩展写法
    public static void reorder(int[] array,boolean fun){
        int beginIndex = 0;
        int endIndex = array.length-1;
        while (beginIndex<endIndex){
            while (!isEnent(beginIndex))beginIndex++;
            while (isEnent(endIndex))endIndex--;
            if (beginIndex>=endIndex)break;
            int temp = array[beginIndex];
            array[beginIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
    public static boolean isEnent(int n){
        return (n&1)==0;
    }
}
