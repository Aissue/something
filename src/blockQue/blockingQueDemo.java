package blockQue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Administrator on 2017/9/28.
 */
public class blockingQueDemo {

    public static void main(String[] args) {
        final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                for(;;){
                    i++;
                    try {
                        Thread.sleep(1000);
                        System.out.println("puting..."+i+"now is "+blockingQueue.size());
                        blockingQueue.put(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){
                    try {
                        Thread.sleep(5000);
                        int x = blockingQueue.take();
                        System.out.println("getting..."+"==="+x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
