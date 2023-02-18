package MonotonicStack;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/18 11:24
 * @description 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 **/
public class dailyTemperatures_ {

    public int[] dailyTemperatures(int[] temperatures) {
        //递增栈,记录下标
        Stack<Integer>st=new Stack<>();
        int[]res=new int[temperatures.length];
        st.push(0);//将第一个元素的下标弹入栈中
        for (int i = 1; i < temperatures.length; i++) {
            if(temperatures[i]<temperatures[st.peek()]){
                st.push(i);//数组元素小于栈顶元素,则将该元素下标推入栈中
            }else if(temperatures[i]==temperatures[st.peek()]){
                st.push(i);
            }else{
                while (!st.empty()&&temperatures[i]>temperatures[st.peek()]){
                    res[st.peek()]=i-st.peek();
                    st.pop();
                }
                st.push(i);
            }
        }
        return res;
    }
}
