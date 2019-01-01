package sulotion.number39;


/**
 * created by tianfeng on 2019/1/1
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 出现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalfNumber {
    //解法一：利用类似于快排寻找中位数（中位数一定是超过一半的这个数字），时间复杂度O（N）
    public static int moreThanHalf(int[] numbers){
        int mid = numbers.length>>1;
        int start = 0;
        int end = numbers.length-1;
        int index = partition(numbers,0,end);
        while (index!=mid){
            if (index>mid){
                index = partition(numbers,start,index-1);
            }else {
                index = partition(numbers,index+1,end);
            }
        }
        int result = numbers[mid];
        if (checkMoreThanHalf(numbers,result))
        return result;
        else return 0;
    }
    private static int partition(int[] numbers,int start,int end){
        int mid = numbers[start];
        int i = start;
        int j = end+1;
        while (true){
            while (numbers[++i]<mid)if (i==end)break;
            while (numbers[--j]>mid)if (j==start)break;
            if (i>=j)break;
            int tem = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tem;
        }
        int tem = numbers[start];
        numbers[start] = numbers[j];
        numbers[j] = tem;
        return j;

    }
    private static boolean checkMoreThanHalf(int[] numbers,int number){
        int time = 0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]==number)time++;
        }
        if (2*time>numbers.length)return true;
        else return false;
    }
    //解法二：利用数组特点，时间复杂度O（N）
    public static int moreThanHalf_B(int[] numbers){
        if (numbers==null)return 0;
        int number=numbers[0];
        int times=0;
        for (int i=0;i<numbers.length;i++){
            int tem = numbers[i];
            if (number==tem){
                times++;
            }else {
                if (times==0){
                    number=numbers[i];
                    times++;
                }else {
                    times--;
                }
            }
        }

        if (checkMoreThanHalf(numbers,number))return number;
        else return 0;
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNumber.moreThanHalf(numbers));
        System.out.println(moreThanHalf_B(numbers));
    }

}
