package sulotion.number2;

/**
 * created by tianfeng on 2018/11/18
 * 使用静态内部类实现单例模式（跟直接使用静态变量或静态代码块来实现单例模式相比，这个实现了懒加载。第一次调用get时
 * 才会new出单例对象）
 */
public class Singleton4 {
    private Singleton4(){}
    static private class Singleton4Handler{
        private static Singleton4 singleton4 = new Singleton4();
    }
    public static Singleton4 getSingleton(){
        return Singleton4Handler.singleton4;
    }
}
