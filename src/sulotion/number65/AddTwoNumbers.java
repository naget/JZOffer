package sulotion.number65;


/**
 * created by tianfeng on 2019/1/7
 * 面试题65：不用加减乘除做加法
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
 * 四则运算符号。
 *
 * 使用位运算（异或，按位与，左移）
 */
public class AddTwoNumbers {
    public static int add(int number1,int number2){
        int sum,carry;
        do {
            sum = number1^number2; //异或得出的是没有算进位的结果
            carry = (number1&number2)<<1;// 进位
            number1 = sum;
            number2 = carry;
        }while (number2!=0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(add(15,69));
    }
}
