package sulotion.number58;

/**
 * created by tianfeng on 2019/1/5
 * 面试题58（一）：翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * 则输出"student. a am I"。
 */
public class ReverseWordsInSentence {
    private static void reverse(StringBuilder stringBuilder,int start,int end){
        while (start<end){
            char startTemp = stringBuilder.charAt(start);
            char endTemp = stringBuilder.charAt(end);
            stringBuilder.replace(start,start+1,String.valueOf(endTemp));//replace这个方法中的参数
            stringBuilder.replace(end,end+1,String.valueOf(startTemp));//start包括，end不包括
            start++;
            end--;
        }
    }

    public static void reverseWordsInSentence(StringBuilder stringBuilder){
        reverse(stringBuilder,0,stringBuilder.length()-1);
        int start =0;
        int end = 0;
        while (start<stringBuilder.length()-1&&end<stringBuilder.length()){
            while (end<stringBuilder.length()&&stringBuilder.charAt(end)!=' ')end++;
            end--;
            reverse(stringBuilder,start,end);
            end +=2;
            start = end;
        }
    }

    public static void leftReverse(StringBuilder s,int number) throws Exception {
        if (number>s.length())throw new Exception("非法输入");
        int firststart = 0;
        int firstend = number-1;
        reverse(s,firststart,firstend);
        reverse(s,firstend+1,s.length()-1);
        reverse(s,0,s.length()-1);
    }

    public static void main(String[] args) throws Exception {
        StringBuilder stringBuilder = new StringBuilder("i am a student.");
        reverseWordsInSentence(stringBuilder);
        System.out.println(stringBuilder);

        StringBuilder stringBuilder1 = new StringBuilder("ABCDEFG");
        leftReverse(stringBuilder1,2);
        System.out.println(stringBuilder1);
    }
}
