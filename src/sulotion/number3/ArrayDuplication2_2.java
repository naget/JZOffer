package sulotion.number3;

/**
 * created by tianfeng on 2018/11/19
 * 二分查找的思路查找重复元素，比如大小在1到N之间的元素大于n个，那么一定有元素重复；但小于n个使也有可能存在重复，
 * 所以这个方法有些重复的元素查不出来
 */
public class ArrayDuplication2_2 {
    public static void resolve(int[] a,int n){//n表示数组中数的大小范围是1到n
        int start = 1;
        int end = n;
        while (start<=end){
            int mid = start+(end-start)/2;
            int count = countRange(a,a.length,start,mid);
            if (start==end){
                if (count>1){
                    System.out.println("找到重复元素："+start);
                    break;
                }
                else break;
            }
            if (count>(mid-start+1))end=mid;
            else start = mid+1;
        }
    }
    private static int countRange(int[] a,int length,int start,int end){
        int count=0;
        for (int i=0;i<a.length;i++){
            if (a[i]>=start&&a[i]<=end)count++;
        }
        return count;
    }
}
