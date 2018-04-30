package singleton;

/**
 * Created by Administrator on 2017/11/15.
 * 常见的两种单例实现方式都存在小小的缺陷，
 * 那么有没有一种方案，既能实现延迟加载，又能实现线程安全呢？
 * 类级内部类
 */
public class BetterSingleton {
    private String name = null;

    static {
        System.out.println("static-black is running...");
    }

    BetterSingleton(String name){
        this.name = name;
    }

    private static class SingletonHolder{
        SingletonHolder(){
            System.out.println("SingletonHolder is running...");
        }
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static BetterSingleton instance = new BetterSingleton("abc");

    }

    private static BetterSingleton getInstance(){
        /**
         * 类级内部类相当于其外部类的成员，
         * 只有在第一次被使用的时候才被会装载。
         */
        return SingletonHolder.instance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {
        /*BetterSingleton b = new BetterSingleton("def");
        BetterSingleton c = new BetterSingleton("def");*/
        /*System.out.println(BetterSingleton.getInstance());
        System.out.println(BetterSingleton.getInstance());*/

    }
}
