package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/15 18:06
 * @description TODO
 **/
public class insert_ {
    public Node insert(Node head, int insertVal) {
        Node node=new Node(insertVal);
        if (head==null){
            node.next=node;
            return node;
        }
        //找到头结点
        Node realHead=head;
        Node tmp=realHead.next;
        while (realHead.val<=tmp.val){
            if (tmp==head){
                //如果循环回到头结点说明全部节点的值都是一样的
                Node node1=realHead.next;
                realHead.next=node;
                node.next=node1;
                return head;
            }
            realHead=realHead.next;
            tmp=tmp.next;
        }
        //所有节点值都小于等于node
        if (realHead.val<=insertVal){
            realHead.next=node;
            node.next=tmp;
            return head;
        }

        //找到最后一个小于node的节点
        while (tmp.val<insertVal){
            tmp=tmp.next;
            realHead=realHead.next;
        }
        realHead.next=node;
        node.next=tmp;

        return head;

    }
}

class Node{
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
