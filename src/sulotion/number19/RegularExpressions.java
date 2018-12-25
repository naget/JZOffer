package sulotion.number19;

/**
 * created by tianfeng on 2018/12/25
 *
 * 面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 * 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 */
public class RegularExpressions {
    public static boolean match(String str,String pattern){
        if (str==null||pattern==null){
            return false;
        }
        return matchCore(str,pattern,0,0);
    }
    private static boolean matchCore(String str,String pattern,int strIndex,int patternIndex){
        if (strIndex==str.length()||patternIndex==pattern.length()){
            return strIndex == str.length() && patternIndex == pattern.length();
        }
        //如果此时对比字符的下一个字符是‘*’，就会比较复杂，需要考虑四种情况。
        if (pattern.charAt(patternIndex+1)=='*'){
            if (pattern.charAt(patternIndex)==str.charAt(strIndex)||pattern.charAt(patternIndex)=='.'){
                return matchCore(str,pattern,strIndex+1,patternIndex+1)||
                        matchCore(str,pattern,strIndex+1,patternIndex)||
                        matchCore(str,pattern,strIndex,patternIndex+2);
            }else {
                return matchCore(str,pattern,strIndex,patternIndex+2);
            }
        }
        if (str.charAt(strIndex)==pattern.charAt(patternIndex)||pattern.charAt(patternIndex)=='.'){
            return matchCore(str,pattern,1+strIndex,1+patternIndex);
        }
        return false;
    }

}
