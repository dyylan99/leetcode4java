package offer2;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/5/1 15:04
 * @description 剑指 Offer II 057. 值和下标之差都在给定的范围内
 **/
public class containsNearbyAlmostDuplicate_ {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k==0){
            return false;
        }
        if (nums.length==0){
            return false;
        }
        List<Pair<Integer,Integer>>list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Pair<Integer, Integer> pair = new Pair<>(nums[i], i);
            list.add(pair);
        }

        Collections.sort(list,(a,b)->{
            if (a.key<0&&b.key>0){
                return -1;
            }
            if (a.key>0&&b.key<0){
                return 1;
            }
            return a.key-b.key;
        });
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j <list.size() ; j++) {
                if (list.get(i).key<0&&list.get(j).key>=0){
                   continue;
                }
                if (list.get(j).key-list.get(i).key<=t){
                    if (Math.abs(list.get(j).v-list.get(i).v)<=k){
                        return true;
                    }
                }else{
                    break;
                }

            }


        }
        return false;

    }
    @Test
    public void test(){
        boolean b = containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1);
        System.out.println(b);
    }


    private class Pair<K,V>{
        K key;
        V v;

        public Pair(K key, V v) {
            this.key = key;
            this.v = v;
        }
    }
}
