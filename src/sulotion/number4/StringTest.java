package sulotion.number4;

/**
 * created by tianfeng on 2018/11/20
 */
public class StringTest {
    public static void main(String[] args) {
        String test = "hello";//这种方法声明的字符串，首先会检查栈中是否存在这个字符串的地址，如果存在，则查找对象，并返回这个地址，
        String test2 = "hello";//如果不存在，则new一个，然后指向它
        String test3 = new String("hello");//这种方法就是不管栈中是否有hello字符串的引用，直接new一个新的hello，并返回它的地址
        System.out.println(test==test2);
        System.out.println(test.equals(test2));
        System.out.println(test==test3);
        StringTest.changeValue(test);
        System.out.println(test);

        test=test.intern();//intern方法首先检查test指向的字符串是否在字符串池中，如果有，返回这个字符串的引用
                            //否则就将这个字符串加入字符串池，返回这个字符串的引用
        System.out.println(test==test3);//还是false，因为test指向的字符串虽然也是“hello”，但这个个“hello”不是池中的hello

        test3 = test3.intern();

        System.out.println(test==test3);//这下是false，应为test3也指向了池中的“hello”



    }
    public static void changeValue(String test){
        test = "hi";
    }
}
