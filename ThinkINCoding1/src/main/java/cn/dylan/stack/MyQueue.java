package cn.dylan.stack;

import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/4 18:57
 * @description 232. 用栈实现队列
 **/
public class MyQueue {
    public Stack<Integer>in;
    public Stack<Integer> out;

    public MyQueue(){
        in=new Stack<>();
        out=new Stack<>();
    }
    public void push(int x){
        in.push(x);
    }
    //用栈模仿队列的核心操作就是当需要弹出操作的时候, 将之前入栈的元素放到出栈的元素中
    public int pop(){
        while (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    public int peek(){
        int res=this.pop();
        out.push(res);
        return res;
    }
    public boolean isEmpty(){
        return in.isEmpty() &&out.isEmpty();
    }
}
