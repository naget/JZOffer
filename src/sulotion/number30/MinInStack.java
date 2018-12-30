package sulotion.number30;

import java.util.Stack;

/**
 * created by tianfeng on 2018/12/30
 * 面试题30：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
 * 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 */
public class MinInStack<T extends Comparable<T>> {
    Stack<T> stack = new Stack<>();
    Stack<T> auxStack = new Stack<>();
    public  T pop(){
        auxStack.pop();
        return stack.pop();
    }
    public void push(T t){
        stack.push(t);
        if (auxStack.isEmpty()||t.compareTo(auxStack.peek())<0){
            auxStack.push(t);
        }else {
            auxStack.push(auxStack.peek());
        }
    }
    public T min(){
        return auxStack.peek();
    }

    public static void main(String[] args) {
        MinInStack<Integer> stack  = new MinInStack<>();
        stack.push(3);
        System.out.println("压入栈3，此刻最小值："+stack.min());
        stack.push(4);
        System.out.println("压入栈4，此刻最小值："+stack.min());
        stack.push(2);
        System.out.println("压入栈2，此刻最小值："+stack.min());

        stack.push(1);
        System.out.println("压入栈1，此刻最小值："+stack.min());

        stack.pop();
        System.out.println("弹出栈，此刻最小值："+stack.min());
        stack.pop();
        System.out.println("弹出栈，此刻最小值："+stack.min());
        stack.push(0);
        System.out.println("压入栈0，此刻最小值："+stack.min());

    }
}
