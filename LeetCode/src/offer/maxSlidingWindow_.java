package offer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/29 15:07
 * @description 剑指 Offer 59 - I. 滑动窗口的最大值
 **/
public class maxSlidingWindow_ {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            //当前最大值若为窗口第一个元素,那么就移除
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;


    }

    @Test
    public void test(){
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);

        pq.add(3);
        pq.add(2);
        pq.add(1);
        System.out.println(pq.poll());
    }

}
