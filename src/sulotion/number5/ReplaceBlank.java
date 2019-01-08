package sulotion.number5;

/**
 * created by tianfeng on 2018/11/20
 * 面试题5：替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如输入“We are happy.”，
 * 则输出“We%20are%20happy.”。
 *
 * 替换空格为%20：先计算出新字符串的长度，然后从后向前替换，相比于从前向后替换，移动字符数量减少。
 * 当然我们可以用库函数replaceAll直接解决
 */
public class ReplaceBlank {
    public static void replace(StringBuilder s){
        int newlength = 0;
        int blankNumber = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' ')blankNumber++;
        }
        newlength = s.length()+blankNumber*2;
        StringBuilder ss = new StringBuilder(newlength);
        ss.setLength(newlength);//如果没有setLength，ss内部的count就会为0，当我们setCharAt（i）时就会报越界错误
        int i = s.length()-1;
        int j = newlength-1;
        while (i>=0&&j>=i){
            if (s.charAt(i)==' '){
                ss.setCharAt(j--,'0');
                ss.setCharAt(j--,'2');
                ss.setCharAt(j--,'%');
            }else {
                ss.setCharAt(j--,s.charAt(i));
            }
            i--;
        }
        System.out.println(ss);
    }

    public static void main(String[] args) {
        ReplaceBlank.replace(new StringBuilder("we are family"));
    }
}
