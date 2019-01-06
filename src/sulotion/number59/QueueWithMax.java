package sulotion.number59;

import java.util.ArrayDeque;

/**
 * created by tianfeng on 2019/1/6
 * 面试题59（二）：队列的最大值
 * 题目：请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的时间复杂度是
 * O（1）
 */
public class QueueWithMax<T extends Comparable<T>> {
    private  ArrayDeque<T> date = new ArrayDeque<>();
    private  ArrayDeque<T> maxDeque = new ArrayDeque<>();
    public void push_back(T number){
        while (!maxDeque.isEmpty()&&maxDeque.peekFirst().compareTo(number)<0)maxDeque.pollLast();
        date.offerLast(number);
        maxDeque.offerLast(number);
    }
    public T popFront(){
        if (date.peekFirst().compareTo(maxDeque.peekFirst())==0)maxDeque.pollFirst();
        return date.pollFirst();
    }
    public T max(){
        if (!maxDeque.isEmpty())return maxDeque.peekFirst();
        return null;
    }
}
