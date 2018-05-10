package listsort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    @Test
    public void test1(){
        List<User> users = new ArrayList<>();
        User u1 = new User(4,"abc");
        User u2 = new User(1,"ddd");
        User u3 = new User(5,"989i");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        System.out.println("before sort:");
        for(User u:users){
            System.out.println(u.toString());
        }
        List<User> newList = listSort(users);
        System.out.println("after sort:");
        for(User u:newList){
            System.out.println(u.toString());
        }

    }

    public List listSort(List list){
        Collections.sort(list,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                User u1 = (User)o1;
                User u2 = (User)o2;
                return u1.getName().compareTo(u2.getName());
            }
        });
        return list;
    }
}
