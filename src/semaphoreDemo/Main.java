package semaphoreDemo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * 信号量，可以控制并发数量
 */
public class Main {
    @Test
    public void test1(){
        //Semaphore的默认实现是非公平性
        Semaphore semaphore = new Semaphore(5,true);
        ExecutorService threadPool = Executors.newFixedThreadPool(30);
        for (int i=0;i<30;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();

                    }catch (Exception e){

                    }finally {
                        semaphore.release();
                    }
                }
            });
        }
    }
}
