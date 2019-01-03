package sulotion.number48;

/**
 * created by tianfeng on 2019/1/3
 * 面试题48：最长不含重复字符的子字符串
 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
 * 字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 */
public class LongestSubStringWithoutDup {
    public static int getLongestLen(String string){
        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[26];
        for (int i = 0;i<26;i++){
            position[i] = -1;
        }
        for (int i = 0;i<string.length();i++){
            char c = string.charAt(i);
            int preIndex = position[c-'a'];
                if (preIndex<0){
                    curLength++;
                }else {
                    int d = i-preIndex;
                    if (d>curLength){
                        curLength++;
                    }else {
                        curLength=d;
                    }
                }
                position[c-'a'] = i;
                if (curLength>maxLength)maxLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getLongestLen("arabcacfr"));
    }
}
