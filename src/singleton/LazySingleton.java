package singleton;

/**
 * Created by Administrator on 2017/11/15.
 * 懒汉式设计模式:时间换空间，每次创建的时候都会加锁，是线程安全的
 * 性能上会慢
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
