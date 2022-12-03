package Test;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/9 22:26
 * @description TODO
 **/

public class test1 {
    @Test
    public void test(){
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2=new ArrayList<>();
        list2.add(1);
        list2.add(3);
        Set<List<Integer>>set=new HashSet<>();
        set.add(list1);
        set.add(list2);
        for (List<Integer> list : set) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
