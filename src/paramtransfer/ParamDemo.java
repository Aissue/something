package paramtransfer;

import org.junit.Test;

/**
 * 参数传递的一种新形式
 */
public class ParamDemo {

    @Test
    public void test1(){
//        test0("abc","def","test");
        test0(new String[]{"blockQue", "threadlocal", "singleton"});
    }

    public String test0(String ... strings){
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        return null;
    }
}
