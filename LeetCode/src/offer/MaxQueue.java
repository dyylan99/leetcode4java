package offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/1 14:25
 * @description 面试题59 - II. 队列的最大值
 **/
public class MaxQueue {

    Deque<Integer>queue;
    Deque<Integer>helpQueue;

    public MaxQueue() {
        queue=new ArrayDeque<>();
        helpQueue=new ArrayDeque<>();
    }

    public int max_value() {
        if(helpQueue.isEmpty()){
            return -1;
        }
        return helpQueue.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!helpQueue.isEmpty()&&value>helpQueue.peekLast()){
            helpQueue.pollLast();
        }
        helpQueue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int val=queue.pop();
        if(helpQueue.peek()==val){
            helpQueue.pop();
        }
        return val;
    }
}
