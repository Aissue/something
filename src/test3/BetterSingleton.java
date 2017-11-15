package test3;

/**
 * Created by Administrator on 2017/11/15.
 * 常见的两种单例实现方式都存在小小的缺陷，
 * 那么有没有一种方案，既能实现延迟加载，又能实现线程安全呢？
 * 类级内部类
 */
public class BetterSingleton {
    private static class SingletonHolder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static BetterSingleton instance = new BetterSingleton();

    }

    public static BetterSingleton getInstance(){
        /**
         * 类级内部类相当于其外部类的成员，
         * 只有在第一次被使用的时候才被会装载。
         */
        return SingletonHolder.instance;
    }
}
