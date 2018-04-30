package observerDemo;

import java.util.Observable;
import java.util.Observer;

/**
 * 被观察的对象
 * 它可以添加多个观察者，就是说不同的观察者响应同一个变化
 */
public class observableDemo extends Observable{
    //构造方法
    public observableDemo(Observer observer){
        addObserver(observer);
    }
    //发通知
    public void call(){
        //setChanged();
        notifyObservers();
    }

    public static void main(String[] args) {
        observableDemo observableDemo = new observableDemo(new observerDemo());
        observableDemo.call();
    }

}
