package cn.dylan.SlidingWindow;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/15 18:43
 * @description 239. 滑动窗口最大值
 **/
public class maxSlidingWindow_ {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]res=new int[nums.length-k+1];
        ArrayDeque<Integer>deque=new ArrayDeque<>();
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peek()<i-k+1){
                deque.poll();
            }
            if (i+1>=k){
                res[index++]=nums[deque.peek()];
            }
        }
        return res;
    }
}
