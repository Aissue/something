package semaphoreDemo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 信号量，可以控制并发数量,当信号量长度为1时，可以实现锁机制
 */
public class Main {
    @Test
    public void test1(){
        //Semaphore的默认实现是非公平性
        Semaphore semaphore = new Semaphore(1,false);
        ExecutorService threadPool = Executors.newFixedThreadPool(30);
        for (int i=0;i<30;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(3000);

                    }catch (Exception e){

                    }finally {
                        semaphore.release();
                    }
                }
            });
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
