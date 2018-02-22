package test8;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/2/5.
 * 测试大数之间的运算
 */
public class bigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("9999999999999");
        BigDecimal bigDecimal1 = new BigDecimal("1.9");
        String r = bigDecimal.add(bigDecimal1).toString();
        System.out.println(r);
        Set s = new HashSet();
    }
}
