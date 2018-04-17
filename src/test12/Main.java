package test12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    @Test
    public void test1(){
        List<Object> list = new ArrayList<>();
        list.add("abc");
        list.add("bcd");
        list.add("cde");
        list.add("def");

        list.removeIf(new Predicate<Object >() {
            @Override
            public boolean test(Object s) {
                return false;
            }
        });

        for(Object str : list){
            System.out.println(str);
        }
    }
}
