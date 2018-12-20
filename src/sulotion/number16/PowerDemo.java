package sulotion.number16;

/**
 * created by tianfeng on 2018/12/20
 * 面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * 次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class PowerDemo {
    public static double pow(double base,int exponent){
        int finalExponent = exponent;
        if (base==0&&exponent<0){
            return 0;
        }
        if (exponent<0){
            finalExponent = -exponent;
        }
        double result = doPow(base,finalExponent);
        if (exponent<0){
            result = 1.0/result;
        }
        return result;
    }
    private static double doPow(double base,int finalExponent){
        if(finalExponent == 0){
            return 1;
        }
        if (finalExponent == 1){
            return base;
        }
        double result = doPow(base,finalExponent>>2);
        result*=result;
        if ((finalExponent&0x1)==1){//奇数次幂情况（这里有个求n次方的公式，主要是为了减少做乘法的次数，详见剑指offer第112页）
            result*=base;
        }
        return result;
    }
}
