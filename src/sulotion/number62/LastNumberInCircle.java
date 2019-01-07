package sulotion.number62;

import java.util.ArrayList;

/**
 * created by tianfeng on 2019/1/7
 * 面试题62：圆圈中最后剩下的数字
 * 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class LastNumberInCircle {
    public static int getLastNumberInCircle(int n,int m){
        ArrayList<Integer> circle = new ArrayList<>();
        int size = 0;
        while (size<n){
            circle.add(size);
            size++;
        }
        int current = -1;
        while (circle.size()>1){
            for (int i = 0;i<m;i++){
                current++;
                if (current>=circle.size())current=0;
            }
            circle.remove(current);
            current--;
        }
        return circle.get(0);
    }

    //数学真牛逼
    public static int getLastRemaining(int n,int m){
        if (n<1||m<1)return -1;
        int last = 0;
        for (int i = 2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(getLastNumberInCircle(120,3));
        System.out.println(getLastRemaining(120,3));
    }
}
