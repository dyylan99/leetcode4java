package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/1 13:48
 * @description 面试题45. 把数组排成最小的数
 **/
public class minNumber_ {
    public String minNumber(int[] nums) {
        if(nums.length==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Integer>pq=new PriorityQueue<>((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (int) (Long.parseLong(s1+s2)-Long.parseLong(s2+s1));
        });
        for (int num : nums) {
            pq.add(num);
        }

       while (!pq.isEmpty()){
           sb.append(pq.poll());
       }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(minNumber(new int[]{10, 2}));
    }
}
