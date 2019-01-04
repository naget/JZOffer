package sulotion.number53;

/**
 * created by tianfeng on 2019/1/4
 * 面试题53（二）：0到n-1中缺失的数字
 * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
 * 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
 * 中，请找出这个数字。
 */
public class MissingNumber {
    public static int getMissingNumber(int[] numbers){
        return getMissingNumber(numbers,0,numbers.length-1);
    }
    private static int getMissingNumber(int[] numbers,int start,int end){
        if (start>end)return -1;
        int mid = start + (end-start)/2;
        if (numbers[mid]>mid){
            if (mid==0||numbers[mid-1]==mid-1)return mid;
            else end=mid-1;
        }else {
            start = mid+1;
        }
        return getMissingNumber(numbers,start,end);
    }

    public static void main(String[] args) {
        int[] numbers = {0,1,2,3,4,5,6,7,8,9,11,12,13};
        System.out.println(getMissingNumber(numbers));
    }
}
