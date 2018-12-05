package sulotion.number9;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * created by tianfeng on 2018/12/5
 * 两个队列实现一个栈
 */
public class StackFromQueue {
    LinkedBlockingQueue<Integer> current = new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Integer> another = new LinkedBlockingQueue<>();
    public void push(Integer integer) throws InterruptedException {
        this.current.put(integer);
    }
    public Integer pop() throws InterruptedException {
        Integer ele = null;
        while (!current.isEmpty()){
            ele = current.poll();
            if (!current.isEmpty()){
                another.put(ele);
            }
        }
        LinkedBlockingQueue<Integer> tem = new LinkedBlockingQueue<>();
        tem = current;
        current = another;
        another = tem;
        return ele;
    }
}
