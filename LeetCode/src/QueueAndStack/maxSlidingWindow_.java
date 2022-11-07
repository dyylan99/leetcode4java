package QueueAndStack;

import org.junit.Test;

import java.util.*;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/7 18:30
 * @description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 *
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 *
 * 239. 滑动窗口最大值
 **/
public class maxSlidingWindow_ {
    @Test
    public void test(){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        //List<Integer>list=new ArrayList<>();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        //System.out.println(list.get(0));
    }

    //方法一:利用队列暴力求解
    //超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer>que=new ArrayDeque<>();
        //List<Integer>list=new ArrayList<>();
        int len=nums.length;
        int []res=new int[len-k+1];
        for (int i = 0; i < k; i++) {
            //que.add(nums[i]);
           que.add(nums[i]);
        }
        res[0]=que.stream().max((a,b)->{
            return a.compareTo(b);
        }).get();
        for (int i = 1; i < len-k+1; i++) {
           que.add(nums[k+i-1]);
            que.remove();
            res[i]=que.stream().max((a,b)-> a.compareTo(b)).get();
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k){
        if (nums.length==1){
            return nums;
        }
        int len=nums.length;
        int[]res=new int[len-k+1];
        int number=0;
        MyQueue myQueue=new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[number++]=myQueue.peek();
        for (int i = k; i < len; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[number++]=myQueue.peek();
        }
        return res;

    }

}

//单调队列
class MyQueue{
    Deque<Integer>queue=new LinkedList<>();
    void poll(int val){
        if(!queue.isEmpty()&&val==queue.peek()){
            queue.poll();
        }
    }
    void add(int val){
        while (!queue.isEmpty()&&val>queue.peekLast()){
            queue.removeLast();
        }
        queue.add(val);
    }
    int peek(){
        return queue.peek();
    }
}
