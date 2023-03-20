package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/16 13:30
 * @description 剑指 Offer 09. 用两个栈实现队列
 **/
public class CQueue {
    //按插入顺序倒序存储
    private Stack<Integer>s1;
    //按插入顺序正序存储
    private Stack<Integer>s2;


    public CQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.empty()){
            if(s1.empty()){
                return -1;
            }else{
                while (!s1.empty()){
                    s2.push(s1.pop());
                }
            }
        }
        return s2.pop();
    }
}
