package sulotion.number41;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * created by tianfeng on 2019/1/1
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class StreamMedian {
    private static PriorityQueue<Integer> min = new PriorityQueue<>();//java中优先队列默认是一个小堆
    private static PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//传入一个自定义比较器，使其成为大堆

    public static void insert(int number){
        if (((max.size()+min.size())&1)==0){
            if (max.size()>0&&number<max.peek()){
                max.add(number);
                number = max.poll();
            }
            min.add(number);
        }else {
            if (min.size()>0&&number>min.peek()){
                min.add(number);
                number = min.poll();
            }
            max.add(number);
        }
    }
    public static int getMidian(){
        int size = max.size()+min.size();
        if ((size&1)==1){
            return min.peek();
        }else {
            return (min.peek()+max.peek())/2;
        }
    }

    public static void main(String[] args) {
        int[] number = {2,8,5,6,4,9,7,1,3};
        for (int i = 0;i<number.length;i++ ){
            insert(number[i]);
        }
        System.out.println("中位数是:"+getMidian());
    }
}
