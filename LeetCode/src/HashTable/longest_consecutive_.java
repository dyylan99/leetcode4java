package HashTable;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2024/7/29 23:18
 * @description 128. 最长连续序列
 **/
public class longest_consecutive_ {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res=0;
        for (Integer num : set) {
            //找到连续的数的最小的哪一个, 避免多次重复查找叠加
            if(!set.contains(num-1)){
                int cur=num;
                int curLength=1;
                while (set.contains(cur+1)){
                    curLength++;
                    cur++;
                }
                res=Math.max(res,curLength);
            }
        }
        return res;
    }
    @Test
    public void test(){
        List<Integer>test=null;
        List<Integer>test2=new ArrayList<>();
        Optional.ofNullable(test).orElse(new ArrayList<>()).forEach(a->{
            System.out.println(a);
        });
        test2.add(2);
        test2.add(3);
        Optional.ofNullable(test2).orElse(new ArrayList<>()).forEach(a->{
            System.out.println(a);
        });


    }
}
