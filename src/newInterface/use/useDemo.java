package newInterface.use;

import newInterface.impl.myInterfaceImpl;
import newInterface.myInterface;
import org.junit.Test;

/**
 * 1、用@Test注解的方法必须没有返回值，返回值类型无：void
    2、用@Test注解的方法必须没有入参。
 */
public class useDemo {
    public myInterface myInter = new myInterfaceImpl();

    @Test
    public void test1(){
        String str = myInter.normal1("test...");
        System.out.println(str);
        String str2 = myInter.test();
        System.out.println(str2);
        String str3 = myInterface.test2();
        System.out.println(str3);
    }

}
