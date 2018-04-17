package test9;

import org.apache.activemq.util.ThreadTracker;

/**
 * Created by Administrator on 2018/2/11.
 */
public class myThread implements Runnable{
    private static int count;

    public myThread(){
        count = 0;
    }

    public String  getCount(){
        return "得到的数是："+count;
    }

    public synchronized void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"我是加锁的方法1");
        Thread.sleep(5000);
    }

    public synchronized void test2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"我是加锁的方法2");
        Thread.sleep(5000);
    }

    @Override
    public void run() {
        //synchronized (this){
            for(int i=0;i<5;i++){
                try {
                    if("A".equals(Thread.currentThread().getName())){
                        test1();
                    }else{
                        test2();
                    }
                    //System.out.println(Thread.currentThread().getName()+":"+count++);
                    Thread.sleep(500);
                }catch (Exception e){

                }
            }
        //}
    }
}
