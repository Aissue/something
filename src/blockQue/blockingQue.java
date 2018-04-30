package blockQue;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列测试
 * Created by Administrator on 2017/9/28.
 */
public class blockingQue {
    private BlockingQueue<String> blockingQueue;

    @Before
    public void beforeSet(){
//        this.blockingQueue = new LinkedBlockingQueue<>(10);
        this.blockingQueue = new ArrayBlockingQueue<>(2);

    }

    @Test
    public void test1(){
        for(int i=0;i<3;i++){
            /*add(e)添加元素队列满了的话会报错java.lang.IllegalStateException: Queue full*/
//            blockingQueue.add("test"+i);
            /*offer(e)添加元素队列满了的话会返回false，不会报错*/
//            System.out.println(blockingQueue.offer("test"+i));
            try {
                /*当加入第三个元素时线程阻塞，要等到有足够空间才自动唤醒*/
                blockingQueue.put("test"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");

    }

}
