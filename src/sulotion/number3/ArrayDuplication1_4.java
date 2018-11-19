package sulotion.number3;

import java.util.BitSet;

/**
 * created by tianfeng on 2018/11/19
 * 找出数组中重复元素，采用bitmap(java中对bitmap的实现是BitSet类)，跟hashset相似
 * bitmap使用一个bit来表示每个元素的状态，所占空间大大减少
 *
 * 查看bitmap的其他使用以及自己实现的bitmap可移步https://mp.weixin.qq.com/s/l9k3v-WZo54nHEEYrNr6Og
 */
public class ArrayDuplication1_4 {
    public static void resolve(int[] a,int n){
        BitSet bitSet = new BitSet(n);
        for (int i = 0;i<a.length;i++){
            if (bitSet.get(a[i])) System.out.println("找到重复元素"+a[i]);
            bitSet.set(a[i]);
        }
    }
}
