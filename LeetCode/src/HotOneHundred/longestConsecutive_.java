package HotOneHundred;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/6 14:24
 * @description 128. 最长连续序列
 **/
public class longestConsecutive_ {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums.length;
        }
        Set<Integer>set=new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest=1;
        for (int num : nums) {
            if(set.remove(num)){
                int curLength=1;
                int cur=num;
                //向左搜索
                while (set.remove(cur-1)){
                    cur--;
                }
                curLength+=(num-cur);
                //向右搜素
                cur=num;
                while (set.remove(cur+1)){
                    cur++;
                }
                curLength+=(cur-num);
                longest=Math.max(curLength,longest);
            }
        }
        return longest;

    }

    public int longestConsecutive1(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums.length;
        }
        int res=0;
        int tem=1;
        //优先最小队列
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int num : nums) {
            pq.add(num);
        }
        Integer nums1 = pq.poll();
        while (!pq.isEmpty()){
            Integer nums2 = pq.poll();
            if(nums2-nums1==1){
                tem++;
            }else if (nums2.equals(nums1)){

            }else{
                res=Math.max(res,tem);
                tem=1;
            }
            nums1=nums2;
        }
        return Math.max(res,tem);
    }

    @Test
    public void test(){
        System.out.println(longestConsecutive1(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
