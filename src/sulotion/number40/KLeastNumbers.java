package sulotion.number40;


/**
 * created by tianfeng on 2019/1/1
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 */
public class KLeastNumbers {
    //快排思想，时间复杂度O(N)，但是不适合处理海量数据
    public static void kLeastNumbers(int[] numbers,int k){
        int start = 0;
        int end = numbers.length-1;
        int index = partition(numbers,0,end);
        while (index!=k-1){
            if (index>k-1){
                index = partition(numbers,start,index-1);
            }else {
                index = partition(numbers,index+1,end);
            }
        }
        for (int i = 0;i<k;i++){
            System.out.print(numbers[i]+" ");
        }
        System.out.println();
    }
    private static int partition(int[] numbers,int start,int end){
        int i = start;
        int j = end+1;//注意这里要写成end+1,配合上A行中的--j结果才会正确。如果写成j=end,A处用j--，就会出错。
        while (true){//因为有可能j--返回的是之前的j，而交换时候却用的是j--之后的j
            while (numbers[++i]<numbers[start])if (i==end)break;
            while (numbers[--j]>numbers[start])if (j==start)break;//A
            if (i>=j)break;
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        int temp = numbers[start];
        numbers[start] = numbers[j];
        numbers[j] = temp;
        return j;

    }
  //大堆
    static class Heap{
        int[] heap;
        boolean isfull;
        int index = 1;
        public Heap(int k){
            heap = new int[k+1];
        }
        public void put(int number){
            if (isfull)putCore(number);
            else {
                if (index<heap.length){
                    heap[index++] = number;
                }
                if (index==heap.length){
                    isfull = true;
                    for (int i = heap.length/2;i>0;i--){
                        sink(i);
                    }
                }
            }
        }
        private void putCore(int number){
            if (number>=heap[1])return;
            heap[1] = number;
            sink(1);
        }
        //堆的下沉排序，将最大的元素换到heap[1]
        private void sink(int index){
            while (2*index<=heap.length-1){
                int j = index*2;
                if (j<heap.length-1&&heap[j+1]>heap[j])j++;
                if (heap[index]>=heap[j])break;
                int temp = heap[index];
                heap[index] = heap[j];
                heap[j] = temp;
                index = j;
            }
        }
        public void print(){
            for (int i = 1;i<heap.length;i++){
                System.out.print(heap[i]+" ");
            }
            System.out.println();
        }
    }
    //使用堆来得到最小的K个数
    public static void KLeastNumbers(int[] numbers,int k){
        Heap heap = new Heap(k);
        for (int i = 0;i<numbers.length;i++){
            heap.put(numbers[i]);
        }
        heap.print();

    }
    public static void main(String[] args) {
        int[] numbers = {1,9,5,6,2,3,4,8,7};
        kLeastNumbers(numbers,3);//使用快排思想
        KLeastNumbers(numbers,3);//使用堆
    }
}
