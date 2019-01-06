package sulotion.number60;


/**
 * created by tianfeng on 2019/1/6
 * 面试题60：n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
 * 的所有可能的值出现的概率。
 *
 *
 */
public class DicesProbability {// TODO: 2019/1/6 代码待修改
    private static int gMaxValue = 6;
    public static void printProbability(int number){//number是骰子个数
        if (number<1)return;
        int maxSum = number*gMaxValue;   //s的最大值
        int[] probabilities = new int[maxSum-number+1];
        for (int i = number;i<maxSum;i++){
            probabilities[i-number] = 0;
        }
        probability(number,probabilities);
        double total = Math.pow(gMaxValue,number);//一共有total种可能性
        for (int i = number;i<=maxSum;i++){
            double ratio = probabilities[i-number]/total;
            System.out.println("s为"+i+"的概率是："+ratio);
        }
    }
    private static void probability(int number,int[] probabilities){
        for (int i = 1;i<=gMaxValue;i++){
            probability(number,number,i,probabilities);
        }
    }
    private static void probability(int original,int current,int sum,int[] probabilities){
        if (current==1){
            probabilities[sum-original]++;
        }else {
            for (int i = 1;i<gMaxValue;i++){
                probability(original,current-1,i+sum,probabilities);
            }
        }
    }

    public static void printProbabilities_solution2(int number){
        if (number<1)return;
        int[][] probabilities = new int[2][gMaxValue*number+1];
        for (int i = 0;i<gMaxValue*number+1;i++){
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }
        int flag = 0;
        for (int i = 1;i<=gMaxValue;i++){
            probabilities[flag][i] = 1;
        }
        for (int k = 2;k<=number;++k){
            for (int i = 0;i<k;i++){
                probabilities[1-flag][i] = 0;
            }
            for (int i = k;i<=gMaxValue*k;i++){
                probabilities[1-flag][i] = 0;
                for (int j = 1;j<=i&&j<=gMaxValue;j++){
                    probabilities[1-flag][i] += probabilities[flag][i-j];
                }
            }
            flag = 1-flag;
        }
        double total = Math.pow(gMaxValue,number);
        for (int i = number;i<=gMaxValue*number;i++){
            double ratio = probabilities[flag][i]/total;
            System.out.println("s为"+i+"的概率是："+ratio);
        }
    }

    public static void main(String[] args) {
        printProbability(4);
        printProbabilities_solution2(4);
    }
}
