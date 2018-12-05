package sulotion.number9;

import java.util.Stack;

/**
 * created by tianfeng on 2018/12/5
 * 用两个栈实现一个队列
 */
public class QueueFromStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void add(Integer integer){
        this.s1.push(integer);
    }
    public Integer take(){
        if (!s2.empty()){
            return s2.pop();
        }else {
            while (!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
}
