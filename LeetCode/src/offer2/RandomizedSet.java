package offer2;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 21:21
 * @description TODO
 **/
public class RandomizedSet {

    public Map<Integer,Integer>map=new HashMap<>();
    public List<Integer>list=new ArrayList<>();
    Random random=new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)){
            Integer index = map.get(val);
            //结尾交换
            list.set(index,list.get(list.size()-1));
            //更新map
            map.put(list.get(list.size()-1),index);
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        int i = random.nextInt(size);
        return list.get(i);
    }

    @Test
    public void test(){
        System.out.println(insert(0));
        System.out.println(insert(1));
        System.out.println(remove(0));
        System.out.println(insert(2));
        System.out.println(remove(1));
        System.out.println(getRandom());
    }
}
