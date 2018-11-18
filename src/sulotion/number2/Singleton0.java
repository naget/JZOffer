package sulotion.number2;

/**
 * created by tianfeng on 2018/11/18
 * 单线程下的单例模式
 */
public class Singleton0 {
    private Singleton0(){}
    private static Singleton0 singleton0 = null;
    public static Singleton0 getSingleton0(){
        if (singleton0==null){
            singleton0 = new Singleton0();
            return singleton0;
        }else {
            return singleton0;
        }
    }
}
