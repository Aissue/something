package test8;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by Administrator on 2018/2/6.
 *
 */
public class simpleDemoTest {

    private Map<String,String> map = null;
    @Before
    public void beforeTest(){
        map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(i+"","sth"+i);
        }

    }

    /**
     * 遍历map方式1
     * map.keySet()
     * map.values()
     */
    @Test
    public void test1(){
        if(map!=null){
           for(String s : map.keySet()){
               System.out.println("key is :"+s);
           }
            for(String s : map.values()){
                System.out.println("value is :"+s);
            }
        }

    }

    /**
     * 遍历map方式2
     * Entry
     */
    @Test
    public void test2(){
        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 遍历方式3
     * 使用Iterator
     */
    @Test
    public void test3(){
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * jdk1.8 最新遍历方法lambda
     */
    @Test
    public void test4(){
        map.forEach((key, value)->{
            System.out.println(key+":"+value);
        });
    }
}
