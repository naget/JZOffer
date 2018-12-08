package sulotion.number11;

/**
 * created by tianfeng on 2018/12/8
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素——二分法
 */
public class MinNumber {
    public int min(int[] a){
        int left = 0;
        int right = a.length-1;
        int mid = left;
        while (a[left]>=a[right]){
            if (right-left==1){
                mid = right;
                break;
            }
            mid = left+(right-left)/2;
            if (a[left]==a[right]&&a[left]==a[mid]){//左中右三数相等，只能顺序查找
                return searchInOrder(a);
            }
            if (a[mid]>=a[left]){
                left = mid;
            }else if(a[mid]<=a[right]){
                right = mid;
            }

        }
        return a[mid];
    }
    public int searchInOrder(int[] a){
        int min = 0;
        for (int i=1;i<a.length;i++){
            if (a[i]<=a[min]){
                min=i;
            }
        }
        return a[min];
    }
}
