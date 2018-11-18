package sulotion.number2;

/**
 * created by tianfeng on 2018/11/18
 * 双重检测锁单例模式(注意使用volatile进行修饰，避免重排序发生，使得其他线程访问到没有初始化完成的对象)
 */
public class Singleton1 {
    private Singleton1(){}
    private volatile static Singleton1 singleton1 = null;
    public static Singleton1 getSingleton1(){
        if (singleton1==null){
            synchronized (Singleton1.class){
                if (singleton1==null){
                    singleton1 = new Singleton1();
                    return singleton1;
                }
                return singleton1;
            }
        }
        return singleton1;
    }
}
