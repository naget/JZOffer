package sulotion.number50;


/**
 * created by tianfeng on 2019/1/3
 * 面试题50（二）：字符流中第一个只出现一次的字符
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
 * 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
 * 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
public class FirstCharInstream {
    private static int[] record;
    private static int index=0;
    public static void insert(char c){
        if (record == null){
            record = new int[256];
            for (int i = 0;i<256;i++){
                record[i] = -1;
            }
        }
        if (record[c]==-1){
            record[c] = index;
        }else if(record[c]>=0){
            record[c] = -2;
        }
        index++;
    }
    public static char getChar(){
        int min = Integer.MAX_VALUE;
        char c='\0';
        for (int i = 0;i<256;i++){
            if (record[i]>=0&&record[i]<min){
                c = (char)i;
                min = record[i];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "google";
        for (int i=0;i<s.length();i++){
            insert(s.charAt(i));
            System.out.println(getChar());
        }
    }
}
