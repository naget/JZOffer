package sulotion.number2;

/**
 * created by tianfeng on 2018/11/18
 * 枚举类实现单例模式（实现单例的最优实现方法，除了枚举，其他五个方法中都可以通过反射调用他们的私有构造器，
 * 从而破坏单例；第二就是序列化也会破坏单例，除非重写readResolve方法）
 *
 * Constructor的newInstance方法会判断是否是枚举，如果是枚举，它会禁止通过反射进行实例化。
 * 在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，
 * 反序列化的时候则是通过java.lang.Enum的valueOf方法来根据名字查找枚举对象。
 */
public enum Singleton5 {
    SINGLETON_5;
    public Singleton5 getSingleton5(){
        return SINGLETON_5;
    }
}
