package sulotion.number38;

/**
 * created by tianfeng on 2018/12/31
 * 面试题38：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 *
 * 自己写不出来，对递归理解的还不到位
 */
public class StringPermutation {
    public static void printStringPermutation(char[] s){
        printCore(s,0);
    }
    private static void printCore(char[] s,int start){
        int len = s.length;
        if (start>=len){
            print(s);
        }else {
            for (int i = start;i<len;i++){
                char tem = s[i];
                s[i] = s[start];
                s[start] = tem;
                printCore(s,start+1);
                tem = s[i];
                s[i] = s[start];
                s[start] = tem;
            }
        }
    }
    private static void print(char[] s){
        for (int i = 0;i<s.length;i++){
            System.out.print(s[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'h','a','p','p','y','n','e','w','y','e','a','r','!'};
        char[] abc = {'a','b','c'};
        StringPermutation.printStringPermutation(abc);
    }
}
