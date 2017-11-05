package test1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/5.
 * 一个关于延迟队列的测试demo
 */
public class delayQueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue delQue = new DelayQueue();
        delQue.add(new delayEntity("first-5s",TimeUnit.SECONDS , 5l));
        delQue.offer(new delayEntity("second-10s",TimeUnit.SECONDS,10l));
        System.out.println(delQue.size());
        System.out.println(delQue.poll());
        Thread.sleep(6000);
        System.out.println(delQue.poll());
        Thread.sleep(6000);
        System.out.println(delQue.poll());
        System.out.println(delQue.size());
    }
}
