package MonotonicStack;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/19 10:39
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 42. 接雨水
 **/
public class trap_ {
    public int trap(int[] height) {
        Stack<Integer>st=new Stack<>();
        st.push(0);
        int res=0;
        for (int i = 1; i < height.length; i++) {
            if(height[st.peek()]>height[i]){
                st.push(i);
            }else if(height[st.peek()]==height[i]){
                st.pop();
                st.push(i);
            }else{
             while (!st.empty()&&height[i]>height[st.peek()]){
                 Integer mid = st.pop();
                 if(!st.empty()){
                     int h=Math.min(height[st.peek()],height[i])-height[mid];
                     int w=i-st.peek()-1;
                     res+=h*w;
                 }
             }
             st.push(i);
            }
        }
        return res;
    }
}
