package test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/11/7.
 * 学习使用ThreadLocal接口
 */
public class ThreadLocalDemo {
    private ExecutorService executorService;

    @Test
    public void test(){
        executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            try{
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }

    @Test
    public void test2(){
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(300);
        /*RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();*/
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        /*RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();*/
        /*RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();*/
        ExecutorService threadPool =
                new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, queue,handler);
        for (int i = 0; i < 9 ; i++){
            try{
                threadPool.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

//            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0)
            {
                 System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }

        }
        threadPool.shutdown();

//        while(!threadPool.awaitTermination(1,TimeUnit.SECONDS));

        boolean loop = true;
        do{
            try {
                loop = !threadPool.awaitTermination(1,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while(loop);


    }

    /**
     * 测试Callable接口和Runnable接口的不同之处
     */
    @Test
    public void test3(){
        executorService = Executors.newFixedThreadPool(3);
        /*Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };*/
        Future<String> future = null;

        for(int i=0;i<10;i++){
            future = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception{
                    Integer i = new Random().nextInt(10);
                    String threadName = Thread.currentThread().getName();
                    TimeUnit.SECONDS.sleep(2);
                    return threadName+":"+i;
                }
            });
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void test4(){
        BlockingQueue queue = new ArrayBlockingQueue(5);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        executorService = new ThreadPoolExecutor(2,5,60l,TimeUnit.SECONDS,queue,handler);
        Future<String> future = null;
        List<Future> resultList = new ArrayList<Future>();
        for(int i=0;i<10;i++){
            future = executorService.submit(new Callable<String>() {
                public String call() throws Exception{
                    Integer i = new Random().nextInt(10);
                    String threadName = Thread.currentThread().getName();
                    TimeUnit.SECONDS.sleep(2);
                    return threadName+":"+i;
                }
            });
            resultList.add(future);

        }
        executorService.shutdown();
        boolean loop = true;
        do{
            try {
                loop = !executorService.awaitTermination(1,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while(loop);
        String result = null;
        try {
            for(Future<String> future1 : resultList){
                result = future1.get();
                System.out.println(result);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
