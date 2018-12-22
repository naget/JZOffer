package sulotion.number17;

import java.util.Arrays;

/**
 * created by tianfeng on 2018/12/22
 *
 * 面试题17：打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * 打印出1、2、3一直到最大的3位数即999。
 *
 * 书上解法——采用char数组表示大数
 */
public class Print1ToMaxOfNDigits {
    public static void printNumbers(int n){
        if (n<0)return;
        char[] array = new char[n];
        Arrays.fill(array,'0');
        while (!increment(array)){
            printNumbers(array);
        }

    }
    private static void printNumbers(char[] array){
        boolean isBegin=false;
        for (int i=0;i<array.length;i++){
            if (!isBegin&&array[i]!='0'){
                isBegin=true;
            }
            if (isBegin){
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }
    private static boolean increment(char[] array){
        boolean isOverFlow = false;
        int nTakeOver = 0;
        for (int i=array.length-1;i>=0;i--){
            int number = array[i]-'0'+nTakeOver;
            if (i==array.length-1){
                number++;
            }
            if (number>=10){
                if (i==0){
                    isOverFlow=true;
                }else {
                    number=number-10;
                    nTakeOver=1;
                    array[i] =(char)(number+'0');
                }
            }else {
                array[i] = (char)(number+'0');
                break;
            }
        }
        return isOverFlow;
    }
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder("aaa");
//        stringBuilder.insert(0,"BBB");
//        System.out.println(stringBuilder);
//
//        char zero = '0';
//        char number = '5';
//        char n = (char)(number+4);
//        System.out.println(number-'0'+4);
//        System.out.println(number+4);//asc码加4，‘5’的asc对应是53
//        System.out.println(number+'4');//‘4’和‘5’的asc码相加
//        System.out.println(n);
        Print1ToMaxOfNDigits.printNumbers(3);
       Print1ToMaxOfNDigits_intArray.print(3);
       Print1ToMaxOfNDigits_putInOrder.print(3);
    }

}
