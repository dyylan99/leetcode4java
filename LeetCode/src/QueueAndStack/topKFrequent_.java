package QueueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/7 23:45
 * @description 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 347. 前 K 个高频元素
 **/
public class topKFrequent_ {
    /*Comparator接口说明:
     * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面*/
    //基于大顶堆实现
    public int[] topKFrequent1(int[] nums, int k) {
        //key为数组元素值, value为该值出现的次数
        Map<Integer,Integer>map=new HashMap<>();
        for (int num : nums) {
            //map.getOrDefault(key,value)返回map中key的value,若map还未包含该key,则添加key-->到defaultValue的映射
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组出现的次数
        //出现次数按冲队头到队尾的顺序从大到小排,出现次数最多的在队头(相当于大顶堆)
        PriorityQueue<int[]>pq=new PriorityQueue<>((p1,p2)->p2[1]-p1[1]);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            pq.add(new int[]{integerIntegerEntry.getKey(),integerIntegerEntry.getValue()});
        }
        int []ans=new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
    //基于小顶堆
    public int[] topKFrequent(int[] nums, int k) {
        //key为数组元素值, value为该值出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            //map.getOrDefault(key,value)返回map中key的value,若map还未包含该key,则添加key-->到defaultValue的映射
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组出现的次数
        //出现次数按冲队头到队尾的顺序从小到大排,出现次数最多的在对头(相当于小顶堆)
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            //如果优先级队列个数小于k,则直接加
            if(pq.size()<k){
                pq.add(new int[]{integerIntegerEntry.getKey(),integerIntegerEntry.getValue()});
            } else{
                //否则就需要删除出现次数最小的队列元素
                if(integerIntegerEntry.getValue()>pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{integerIntegerEntry.getKey(),integerIntegerEntry.getValue()});
                }
            }

        }
        int res[]=new int[k];
        for (int i = k-1; i>=0; i--) {
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
