package sulotion.number59;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * created by tianfeng on 2019/1/6
 * 面试题59（一）：滑动窗口的最大值
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
 * 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
 */
public class MaxValueInSlidingWindow {
    public static ArrayList getMaxValueInSlidingWindow(int[] arrays,int size){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0;i<size;i++){
            while (!arrayDeque.isEmpty()&&arrays[i]>=arrays[arrayDeque.peekLast()])
                arrayDeque.pollLast();
            arrayDeque.offerLast(i);
        }
        for (int i = size;i<arrays.length;i++){
            arrayList.add(arrays[arrayDeque.peekFirst()]);
            while (!arrayDeque.isEmpty()&&arrays[i]>=arrays[arrayDeque.peekLast()])arrayDeque.pollLast();
            if (!arrayDeque.isEmpty()&&(i-arrayDeque.peekFirst())>=size)arrayDeque.pollFirst();
            arrayDeque.offerLast(i);
        }
        arrayList.add(arrays[arrayDeque.pollFirst()]);
        return arrayList;
    }

    public static void main(String[] args) {
        int[] arrays = {2,3,4,2,6,2,5,1};
        System.out.println(getMaxValueInSlidingWindow(arrays,3));
    }
}
