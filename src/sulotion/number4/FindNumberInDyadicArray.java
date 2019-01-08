package sulotion.number4;

/**
 * created by tianfeng on 2018/11/20
 * 面试题4：二维数组中的查找
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * 整数，判断数组中是否含有该整数。
 */
public class FindNumberInDyadicArray {
    public static void find(int[][] array,int number){
        int row = array.length;//行
        int col = array[0].length;//列
        for (int i=0,j=col-1;i<row&&j>=0;){
                if (number<array[i][j])j--;
                else if (number>array[i][j])i++;
                else {
                    System.out.println("找到元素："+number+"在"+i+"行"+j+"列");
                    return;
                }
        }
        System.out.println("没有找到元素："+number);

    }

    public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,22},{88,89,95,96}};
        FindNumberInDyadicArray.find(array,22);
    }
}
