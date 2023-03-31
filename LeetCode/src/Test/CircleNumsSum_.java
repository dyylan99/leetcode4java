package Test;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/28 16:19
 * @description 划分循环数组
 **/
public class CircleNumsSum_ {
    public int CircleNumsSum(int[]nums){
        //哈希key是前缀和的值，value是前缀和为key的位置组成的链表。
        // 建好这个map之后只需要再遍历一次前缀和数组，然后找到key是当前前缀和-half的对应数组位置，
        // 依次比对是否小于当前位置，如果小于说明这是一段有效连续数组。
        Map<Integer,List<Integer>>map=new HashMap<>();
        //保存前缀和
        int[]arr=new int[nums.length];

        int sum=0;

        for (int i = 0; i < nums.length; i++) {
            arr[i]=sum;
            sum+=nums[i];
            List<Integer> list;
            if(!map.containsKey(arr[i])){
                list = new ArrayList<>();
            }else{
                list = map.get(arr[i]);
            }
            list.add(i);
            map.put(arr[i],list);
        }
        //此时这个为目标和
        int target=sum/2;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]-target)){
                List<Integer> list = map.get(arr[i] - target);
                for (int i1 = 0; i1 < list.size(); i1++) {
                    if(list.get(i1)<i){
                        count++;
                    }

                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(CircleNumsSum(new int[]{-1, 2, -1, 2}));
        System.out.println(CircleNumsSum(new int[]{1, 1, 1, 1}));
        System.out.println(CircleNumsSum(new int[]{-1, -1, 1, 1}));
    }
}
