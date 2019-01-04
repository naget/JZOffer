package sulotion.number53;

/**
 * created by tianfeng on 2019/1/4
 * 面试题53（一）：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
 * 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
public class NumberOfK {
    public static int getNumberOfK(int k,int[] numbers){
        int number = 0;
        if (numbers!=null&&numbers.length>0){
            int first = getStartIndex(k,numbers,0,numbers.length-1);
            int second = getEndIndex(k,numbers,0,numbers.length-1);
            if (first>-1&&second>-1){
                number = second-first+1;
            }
        }
        return number;
    }
    private static int getStartIndex(int k,int[] numbers,int start,int end){
        if (start>end)return -1;
        int mid = start+(end-start)/2;
        if (numbers[mid]<k)start = mid+1;
        else if (numbers[mid]>k)end = mid-1;
        else {
            if (mid>0&&numbers[mid-1]!=k||mid==0)return mid;
            else end = mid-1;
        }
        return getStartIndex(k,numbers,start,end);
    }
    private static int getEndIndex(int k,int[] numbers,int start,int end){
        if (start>end)return -1;
        int mid = start+(end-start)/2;
        if (numbers[mid]<k)start = mid+1;
        else if (numbers[mid]>k)end = mid-1;
        else {
            if (mid<end&&numbers[mid+1]!=k||mid==end)return mid;
            else start = mid+1;
        }
        return getEndIndex(k,numbers,start,end);
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,3,3,3,4,5};
        System.out.println(getNumberOfK(3,numbers));
    }
}
