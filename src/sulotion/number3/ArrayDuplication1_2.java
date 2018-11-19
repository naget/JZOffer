package sulotion.number3;

import java.util.HashSet;

/**
 * created by tianfeng on 2018/11/19
 * 找出数组中重复的元素——使用hashset解决，时间复杂度O(n)
 * 空间换时间,使用了一个大小为O(n)的hashset
 */
public class ArrayDuplication1_2 {
    public static void resolve(int[] a){
        HashSet<Integer> set = new HashSet<>();
        for (int i:a){
            if (!set.add(i)) System.out.println("重复元素："+i);
        }
    }

    public static void main(String[] args) {//测试用例
        int[] array = {2,3,1,0,2,5,3};
        ArrayDuplication2_2.resolve(array,6);
    }
}
