package sulotion.number53;

/**
 * created by tianfeng on 2019/1/4
 * 面试题53（三）：数组中数值和下标相等的元素
 * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * 1, 3, 5}中，数字3和它的下标相等。
 *
 */
public class IntegerEquelToIndex {
    public static int integerEqualToIndex(int[] array){
        return integerEqualToIndex(array,0,array.length-1);
    }
    private static int integerEqualToIndex(int[] array,int start,int end){
        if (start>end)return -1;
        int mid = start + (end-start)/2;
        if (array[mid]==mid)return mid;
        else if (array[mid]<mid)start=mid+1;
        else end = mid-1;
        return integerEqualToIndex(array,start,end);
    }

    public static void main(String[] args) {
        int[] array = {-3,-1,1,3,5};
        System.out.println(integerEqualToIndex(array));
    }
}
