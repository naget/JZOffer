package sulotion.number66;

/**
 * created by tianfeng on 2019/1/7
 * 面试题66：构建乘积数组
 * 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
 * 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class ConstuctArray {
    public static void multiply(int[] array1,int[] array2){
        int length1 = array1.length;
        int length2 = array2.length;
        if (length1==length2&&length1>1){
            array2[0] = 1;
            for (int i=1;i<length2;i++){
                array2[i] = array2[i-1]*array1[i-1];  //此时array1是原始数组A，array2放入C
            }
            double temp = 1;
            for (int i = length1-2;i>=0;i--){
                temp *= array1[i+1]; //temp表示的是D
                array2[i+1] *= temp;  //此时得出的array2就是所求的B

            }
        }
    }
}
