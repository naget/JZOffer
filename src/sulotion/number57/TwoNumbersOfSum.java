package sulotion.number57;

/**
 * created by tianfeng on 2019/1/5
 * 面试题57（一）：和为s的两个数字
 * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们
 * 的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */
public class TwoNumbersOfSum {
    public static void printTwoNumbers(int[] numbers,int sum){
        int left = 0;
        int right = numbers.length-1;
        while (left<right){
            if (numbers[left] + numbers[right]==sum) {
                System.out.println(numbers[left]+" "+numbers[right]);
                return;
            }else if (numbers[left]+numbers[right]>sum)right--;
            else left++;
        }
        System.out.println("没有找到符合条件的数字");
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,4,7,11,15};
        printTwoNumbers(numbers,15);
    }
}
