package offer2;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 19:37
 * @description 单调栈的经典题
 **/
public class dailyTemperatures_ {
    public int[] dailyTemperatures(int[] temperatures) {
        int[]res=new int[temperatures.length];

        Deque<Integer>stack=new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int tem=temperatures[i];
            while (!stack.isEmpty()&&tem>temperatures[stack.peek()]){
                Integer pre = stack.pop();
                res[pre]=i-pre;
            }
            stack.push(i);
        }
        return res;
    }
    @Test
    public void test(){
        int[] ints = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
