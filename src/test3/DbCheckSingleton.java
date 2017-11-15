package test3;

/**
 * Created by Administrator on 2017/11/15.
 * 双重检验单类模式：懒汉式的实现是线程安全的，这样会降低整个访问的速度，而且每次都要判断
 * 所以，以下是一种基于线程安全的优化
 * 弊端：由于volatile关键字可能会屏蔽掉虚拟机中一些必要的代码优化，所以运行效率并不是很高。
 *      因此一般建议，没有特别的需要，不要使用。
 *      也就是说，虽然可以使用“双重检查加锁”机制来实现线程安全的单例，
 *      但并不建议大量采用，可以根据情况来选用。
 */
public class DbCheckSingleton {
    private static volatile DbCheckSingleton instance = null;

    public static DbCheckSingleton getInstance(){
        if (instance == null){
            synchronized (DbCheckSingleton.class){
                if(instance == null){
                    instance = new DbCheckSingleton();
                }
            }
        }
        return instance;
    }
}
