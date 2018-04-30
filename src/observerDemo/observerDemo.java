package observerDemo;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者，即当被观察的对象发生变化的时候，做出响应
 */
public class observerDemo implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者感应到了被观察对象的变化...");
    }
}
