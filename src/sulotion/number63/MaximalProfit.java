package sulotion.number63;

/**
 * created by tianfeng on 2019/1/7
 * 面试题63：股票的最大利润
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
 * 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
 * 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
 * 收获最大的利润11。
 */
public class MaximalProfit {
    public static int getMaximalProfit(int[] numbers){
        if (numbers==null||numbers.length<2)return 0;
        int min = numbers[0];
        int profit = 0;
        for (int i = 1;i<numbers.length;i++){
            if (numbers[i]<min)min = numbers[i];
            else {
                int temp = numbers[i]-min;
                if (temp>profit)profit = temp;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] numbers = {9,11,8,5,7,12,16,14};
        System.out.println(getMaximalProfit(numbers));
    }
}
