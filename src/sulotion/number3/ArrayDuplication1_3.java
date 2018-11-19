package sulotion.number3;

/**
 * created by tianfeng on 2018/11/19
 * 找出数组中重复的数字——重排数组解法，空间复杂度O(1)，时间复杂度O(n)
 */
public class ArrayDuplication1_3 {
    public  static void resolve(int[] a){
        for (int i=0;i<a.length;i++){
            while (true){
                if (a[i]==i)break;
                if (a[i]==a[a[i]]){
                    System.out.println("找到重复元素："+a[i]);
                    break;
                }
                int temp = a[i];
                a[i] = a[temp];
                a[temp] =temp;
            }

        }
    }
}
