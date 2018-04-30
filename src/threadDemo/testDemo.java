package threadDemo;

import org.junit.Test;

/**
 * Created by Administrator on 2018/2/11.
 */
public class testDemo  {

    @Test
    public void test1(){
        myThread myThread = new myThread();
        Thread t1 = new Thread(myThread,"t1");
        Thread t2 = new Thread(myThread,"t2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        Thread t1 = new Thread(new myThread(),"t1");
        Thread t2 = new Thread(new myThread(),"t2");
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        myThread myThread = new myThread();
        Thread t1 = new Thread(myThread,"A");
        Thread t2 = new Thread(myThread,"B");
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
