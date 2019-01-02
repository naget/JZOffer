package sulotion.number46;

/**
 * created by tianfeng on 2019/1/2
 * 面试题46：把数字翻译成字符串
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
 * 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
 * "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class TranslateNumbersToStrings {
    public static int getTranslationCount(int number){
        if (number<0)return 0;
        String string = String.valueOf(number);
        return getTranslationCount(string);
    }
    private static int getTranslationCount(String string){
        int length = string.length();
        int[] counts = new int[length];
        int count = 0;
        for (int i = length-1;i>=0;i--){
            if (i<length-1){
                count = count+counts[i+1];
            }else count=1;
            if (i<length-1){
                int digit1 = string.charAt(i)-'0';
                int digit2 = string.charAt(i+1)-'0';
                int converted = digit1*10+digit2;
                if (converted>=10&&converted<=25){
                    if (i<length-2){
                        count += counts[i+2];
                    }else count++;
                }
            }
            counts[i] = count;
        }
        count = counts[0];
        return count;
    }
}
