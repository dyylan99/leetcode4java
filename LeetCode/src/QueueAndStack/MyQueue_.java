package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/1 15:44
 * @description 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *232. 用栈实现队列
 **/
public class MyQueue_ {
    Stack<Integer> sIn= new Stack<>();
    Stack<Integer> sOut= new Stack<>();
    public MyQueue_() {

    }

    //入队列方法
    public void push(int x) {
        sIn.push(x);
    }

    public int pop() {
        //只有当sOut为空时,从sIn中导入全部数据
        if(sOut.empty()){
            //导入sIn的数据直到sIn为空
            while (!sIn.empty()){
                sOut.push(sIn.pop());
            }
        }
        int result=sOut.pop();
        return result;
    }

    public int peek() {
        int res=this.pop();
        sOut.push(res);
        return res;
    }

    public boolean empty() {
        return sIn.empty()&&sOut.empty();
    }
}
