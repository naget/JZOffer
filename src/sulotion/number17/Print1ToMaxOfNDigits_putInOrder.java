package sulotion.number17;


import java.util.Arrays;

/**
 * created by tianfeng on 2018/12/22
 * 数字排列的解法
 */
public class Print1ToMaxOfNDigits_putInOrder {
    public static void print(int n){
        int[] array = new int[n];
        Arrays.fill(array,0);
        for (int i=0;i<10;i++){
            array[0]=i;
            print(array,n,0);
        }
    }
    private static void print(int[] array,int length,int index){
        if (index==array.length-1){
            printNumber(array);
            return;
        }
        for (int i=0;i<10;i++){
            array[index+1]=i;
            print(array,length,index+1);
        }
    }
    private static void printNumber(int[] array){
        boolean begin = false;
        for (int i=0;i<array.length;i++){
            if (!begin&&array[i]!=0){
                begin=true;
            }
            if (begin){
                System.out.print(array[i]);
            }
        }
        System.out.println();
    }
}
