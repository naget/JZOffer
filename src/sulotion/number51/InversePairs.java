package sulotion.number51;

/**
 * created by tianfeng on 2019/1/4
 * 面试题51：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
 * 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 归并的思想可以使时间复杂度从N方降到线性对数级别，虽然付出了0（N）的空间
 */
public class InversePairs {
    public static int inversePairs(int[] data){
        if (data==null||data.length<=0)return 0;
        int[] copy = new int[data.length];
        for (int i = 0;i<data.length;i++){
            copy[i] = data[i];
        }
        return inversePairs(data,copy,0,data.length-1);
    }
    private static int inversePairs(int[] data,int[] copy,int start,int end){
        if (start==end){
            copy[start] = data[start];
            return 0;
        }
        int length = (end-start)/2;
        int left = inversePairs(copy,data,start,start+length);
        int right = inversePairs(copy,data,start+left+1,end);
        int i = start+length;
        int j = end;
        int copyIndex =  end;
        int count = 0;
        while (i>=start&&j>=start+left+1){
            if (data[i]>data[j]){
                copy[copyIndex--] = data[i--];
                count += j-start-length;
            }else {
                copy[copyIndex--] = data[j--];
            }
        }
        for (;i>=start;i--){
            copy[copyIndex--] = data[i--];
        }
        for (;j>=start+left+1;j--){
            copy[copyIndex--] = data[j--];
        }
        return count+left+right;
    }

    public static void main(String[] args) {
        int[] data = {7,5,6,4};
        System.out.println(inversePairs(data));
    }
}
