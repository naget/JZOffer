package sulotion.number20;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * created by tianfeng on 2018/12/25
 *
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 */
public class NumbericStrings {
    static int index;
    public static boolean isNumberic(String s){
        boolean numeric = scanInteger(s);
        if (index<s.length()&&s.charAt(index)=='.'){
            index++;
            //采用||的原因：
            //1 小数可以没有整数部分如.23
            //2 小数点后边可以没有数字 如125.
            //3 也可小数点前后都有数字 如111.222
            numeric = scanInteger(s)||numeric;
        }
        if (index<s.length()&&(s.charAt(index)=='e'||s.charAt(index)=='E')){
            index++;
            //采用&&的原因：
            //e前边没有数字或e后边没有数字，整个字符串就不能表示数字
            numeric = numeric&&scanInteger(s);
        }
        return numeric&&s.length()==index;
    }
    private static boolean scanInteger(String s){
        if (index<s.length()&&s.charAt(index)=='+'||s.charAt(index)=='-'){
            index++;
        }
        return scanUnsignedInteger(s);
    }
    private static boolean scanUnsignedInteger(String s){
        int beforeIndex = index;
        while (index<s.length()&&s.charAt(index)>='0'&&s.charAt(index)<='9')index++;
        return index>beforeIndex;
    }

    public static void main(String[] args) {
        System.out.println(NumbericStrings.isNumberic("1a3.14"));
    }

}
