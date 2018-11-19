package sulotion.number3;

import jdk.nashorn.internal.ir.IfNode;

/**
 * created by tianfeng on 2018/11/19
 */
public class ArrayDuplication2_1 {
    public static void resolve(int[] a,int n){//n表示这个数组中数的大小范围是1到n
        int[] aux = new int[n+1];
        for (int i=0;i<a.length;i++){
            if (aux[a[i]]!=0){
                System.out.println("找到重复元素："+a[i]);
            }
            aux[a[i]] = a[i];
        }
    }
}
