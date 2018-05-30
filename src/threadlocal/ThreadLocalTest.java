package threadlocal;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yscredit
 */
public class ThreadLocalTest {

    public ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue(){
            return 8;
        }
    };

    public Integer getNext(){
        Integer integer = threadLocal.get();
        //System.out.println(integer);
        threadLocal.set(++integer);
        //System.out.println(threadLocal.get());
        return threadLocal.get();
    }

    @Test
    public void test1() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<3;j++){
                        System.out.println(Thread.currentThread().getName()+":"+getNext());
                    }
                }
            });
        }
        Thread.sleep(3000L);

    }
}
