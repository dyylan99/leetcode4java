package cn.dylan.String;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/28 15:44
 * @description 32. 最长有效括号
 **/
public class longestValidParentheses_ {
    public int longestValidParentheses(String s) {
        /**
         * 需要确定的是: 我们只会把右括号作为一个边界放到栈中
         */
        int n=s.length(),maxLength=0;
        Deque<Integer>stack=new ArrayDeque<>();
        //虚拟边界
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果是右括号，存在两种情况
            // 1.如果前面可以有左括号和它进行匹配，那么就存在一个由左括号、右括号组成的子串
            // 2.如果前面没有左括号和它进行匹配，那么这个右括号就形成了新的边界。新的子串匹配时，起点必须在该边界右边
            if(c=='('){
                stack.push(i);
            }else{
                // 如果栈的大小为1，说明只存放了边界
                // 说明存放的内容为:边界
                // 相应的做法为边界替换，将旧的边界出栈，然后放入新的边界
                // 说明该右括号找不到和它可以匹配的左括号，那么该子串长度无效。同时这个右括号形成了新的边界(参照物
                if (stack.size()==1){
                    stack.pop();
                    stack.push(i);
                }else{
                    // 如果栈的大小不为1, 说明此时栈中存放着其他左括号的索引, 因此作为匹配弹出
                    // 说明可以找到和它进行匹配的左括号
                    stack.pop();
                    maxLength= Math.max(maxLength,i-stack.peek());
                }
            }
        }
        return maxLength;
    }
}
