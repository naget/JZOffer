package sulotion.number17;

import java.util.Arrays;

/**
 * created by tianfeng on 2018/12/22
 * 面试题17：打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 *
 * 采用int数组表示大数
 */
public class Print1ToMaxOfNDigits_intArray {
    public static void print(int n){
        int[] array = new int[n];
        Arrays.fill(array,0);
        while (!increment(array)){
            print(array);
        }
    }
    private static boolean increment(int[] array){
        boolean isOverFlow = false;
        int ntakeOver = 0;
        for (int i = array.length-1;i>=0;i--){
            int number = array[i]+ntakeOver;
            if (i==array.length-1){
                number++;
            }
            if (number>=10){
                if (i==0){
                    isOverFlow = true;
                }else {
                    number = number-10;
                    array[i] = number;
                    ntakeOver = 1;
                }
            }else {
                array[i] = number;
                break;
            }
        }
        return isOverFlow;
    }
    private static void print(int[] array){
        boolean begin = false;
        for (int i=0;i<array.length;i++){
            if (!begin&&array[i]!=0){
                begin = true;
            }
            if (begin){
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }
}
