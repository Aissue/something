package volatileDemo;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/11/27.
 * 关键字volatile的测试类，主要验证在多线程情况下，
 * volatile对于自增的不安全性
 */
public class VolatileDemo {
    private volatile int i=0;
    @Test
    public void test1(){
        for(int x=0;x<10;x++){
            i++;
        }
        System.out.println(i);
    }

    /**
     * 可以看到，多个线程同时处理一个volatile变量自增时
     * 会出现计算结果不相同的情况
     */
    @Test
    public void test2(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> result = null;
        for(int x=0;x<6;x++){
            result = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception{
                    for(int x=0;x<10;x++){
                        i++;
                    }
                    return i;
                }
            });
        }

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
