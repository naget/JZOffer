package sulotion.number31;

import java.util.Stack;

/**
 * created by tianfeng on 2018/12/30
 * 面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class StackPushPopOrder {
    public static boolean isPopOrder(int[] pushOrder,int[] popOrder){
        Stack<Integer> stack = new Stack<>();
        int popLength = popOrder.length;
        int pushLength = pushOrder.length;
        int popindex = 0;
        int pushindex = 0;
        while (popindex<popLength){
            int popE = popOrder[popindex];
            while (stack.isEmpty()||stack.peek()!=popE){
                if (pushindex>=pushLength)return false;
                stack.push(pushOrder[pushindex++]);
            }
            stack.pop();
            popindex++;
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {4,5,3,2,1};
        int[] falsePopOrder = {4,3,5,1,2};
        System.out.println(StackPushPopOrder.isPopOrder(pushOrder,popOrder));
        System.out.println(StackPushPopOrder.isPopOrder(pushOrder,falsePopOrder));
    }

}
