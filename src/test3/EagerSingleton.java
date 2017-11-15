package test3;

/**
 * Created by Administrator on 2017/11/15.
 * 饿汉式单例模式:典型的空间换时间，当类装载的时候就会创建类的实例，
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return instance;
    }
}
