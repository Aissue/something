package lockDemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
                System.out.println("a is waiting...");
                insert1(Thread.currentThread());
            }
        },"a").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("b is waiting...");
                insert1(Thread.currentThread());
            }
        },"b").start();

        Thread.sleep(2000l);
    }

    @Test
    public void test2() throws InterruptedException {
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        insert2(Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            },"thread["+i+"]").start();
        }
        Thread.sleep(10000l);

    }

    public void insert1(Thread thread){
        //方式1、直接加锁
        lock.lock();
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

    public void insert2(Thread thread) throws InterruptedException {
        //方式2、试着加锁，若加锁成功，则进行处理，否则直接退出，不再等待
//        if(lock.tryLock()){
        if(lock.tryLock(1, TimeUnit.SECONDS)){
            try {
                Thread.sleep(100l);
                System.out.println(thread.getName()+" getting lock...");
                for(int i=0;i<5;i++){
                    list.add(i);
                }
            }catch (Exception e){

            }finally {
                lock.unlock();
                System.out.println(thread.getName()+" releasing lock...");
            }
        }else{
            System.out.println(thread.getName()+" get lock rejecked...");
        }

    }

}
