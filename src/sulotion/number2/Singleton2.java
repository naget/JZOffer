package sulotion.number2;

/**
 * created by tianfeng on 2018/11/18
 * 使用静态变量完成单例模式
 */
public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 singleton2 = new Singleton2();

    public static Singleton2 getSingleton2() {
        return singleton2;
    }
}
