package sulotion.number4;

/**
 * created by tianfeng on 2018/11/20
 * 在一个特殊的二维数组里查找一个数
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
