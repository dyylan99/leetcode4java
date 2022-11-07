package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/1 16:04
 * @description 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 *
 * 225. 用队列实现栈
 **/
public class MyStack    {
    Deque<Integer> q=new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        q.addLast(x);
    }
    public int pop() {
        /**
         * 用队列模拟弹出栈的操作, 一个队列的实现方式为:
         *  将队列元素从队列头部重新添加到队列尾部即可, 最后一个元素除外
         */
        int size=q.size();
        for (int i = 0; i < size-1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public int top() {
        return q.peekLast();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
