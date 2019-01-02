package sulotion.number45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * created by tianfeng on 2019/1/2
 * 面试题45：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
 * 字能排成的最小数字321323。
 */
public class SortArrayForMinNumber {
    public static void printMinNumber(int[] array){
        String[] strings = new String[array.length];
        for (int i = 0;i<array.length;i++){
            strings[i] = String.valueOf(array[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String tem1 = o1+o2;
                String tem2 = o2+o2;
                return String.CASE_INSENSITIVE_ORDER.compare(tem1,tem2);
            }
        });
        for (int i = 0;i<strings.length;i++){
            System.out.print(strings[i]);
        }
    }



    public static void main(String[] args) {
        int[] array = {3,32,321};
        printMinNumber(array);
    }
}
