package sulotion.number50;

/**
 * created by tianfeng on 2019/1/3
 * 面试题50（一）：字符串中第一个只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
 * 'b'。
 */
public class FirstNotRepeatingChar {
    public static char getChar(String s){
        int[] record = new int[256];
        for (int i = 0;i<s.length();i++){
            record[s.charAt(i)]++;
        }
        for (int i = 0;i<s.length();i++){
            if (record[s.charAt(i)]==1)return s.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        System.out.println(getChar("abaccdeff"));
    }
}
