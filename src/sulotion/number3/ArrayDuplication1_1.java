package sulotion.number3;

import java.util.Arrays;

/**
 * created by tianfeng on 2018/11/19
 * 找出数组中重复的数字——排序解法。时间复杂度O(nlogn)
 */
public class ArrayDuplication1_1 {
    public void resolve(int[] a){
        Arrays.sort(a);
        int lastVisit=-1;
        int cur;
        for (int i:a){
            cur = i;
            if (cur==lastVisit) {
                System.out.println("重复元素："+cur);
                break;
            }
            lastVisit = cur;
        }

    }
}
