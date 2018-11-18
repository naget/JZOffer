package sulotion.number2;

/**
 * created by tianfeng on 2018/11/18
 * 使用静态语句块完成单例模式
 */
public class Singleton3 {
    private Singleton3(){}
    private static Singleton3 singleton3;
    static {
        singleton3 = new Singleton3();
    }
    public static Singleton3 getSingleton3(){
        return singleton3;
    }
}
