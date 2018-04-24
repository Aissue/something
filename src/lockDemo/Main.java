package lockDemo;

import org.apache.activemq.leveldb.DelayableUOW;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/4/23.
 */
public class Main {
    private Lock lock = new ReentrantLock();
    private List<Integer> list = new ArrayList<>();
    @Test
    public void test1() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1 is waiting...");
                insert(Thread.currentThread());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2 is waiting...");
                insert(Thread.currentThread());
            }
        }).start();

        Thread.sleep(5000l);
    }

    public void insert(Thread thread){
        System.out.println(thread.getName()+" is waiting...");
        lock.lock();
        System.out.println(thread.getName()+ " is running...");
        try {
            System.out.println(thread.getName()+" getting lock...");
            for(int i=0;i<5;i++){
                list.add(i);
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
            System.out.println(thread.getName()+" releasing lock...");
        }
    }
}
