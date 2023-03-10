package HotOneHundred;

import org.w3c.dom.Node;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/8 11:17
 * @description 155. 最小栈
 **/
public class MinStack {

    private Node node;
    public MinStack() {
        node=new Node();
    }

    public void push(int val) {
        if(node==null){
            node=new Node(val,val);
        }else{
            node=new Node(val,Math.min(val,node.min),node);
        }
    }

    public void pop() {
        node=node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }
    //该链表每个节点都保存着其之前包括该节点的最小值
    class Node{
        int min;
        int val;
        Node next;
        private Node(int val,int min){
            this.min=min;
            this.val=val;
        }
        private Node(int val,int min,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
        private Node(){
            this.min=Integer.MAX_VALUE;
        }
    }

}
