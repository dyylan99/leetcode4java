package offer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/19 14:24
 * @description 剑指 Offer 30. 包含min函数的栈
 **/
public class MinStack {
    /** initialize your data structure here. */
    //包含最小元素方法,调用该方法的时间复杂度为O(1)

    /**
     * 使用链表记录当前节点及之前的节点的最小值,那么就解决了删除栈节点需要变换栈最小值的问题
     * 每次近栈都要比较一下,记录最小值
     */

    class Node{
        int val;
        //记录的是当前节点以及之前入栈的最小值
        int min;
        Node next;

        public Node(int val,int min){
            this.min=min;
            this.val=val;
        }
        public Node(int val,int min,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
        public Node(){
            this.min=Integer.MIN_VALUE;
        }
    }
    private Node stack;

    public MinStack() {
        //头结点
        stack=new Node();
    }
    public void push(int x) {
        if(stack==null){
            stack=new Node(x,x);
        }else{
            //最关键的一步,将新节点的后缀节点指向当前指针,并把当前指针指向新节点,完成了栈的特性
            stack=new Node(x,Math.min(x,stack.min),stack);
        }
    }

    public void pop() {
        stack=stack.next;
    }

    public int top() {
        return stack.val;
    }

    public int min() {
        return stack.min;
    }
}
