package offer2;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/24 20:27
 * @description 剑指 Offer II 028. 展平多级双向链表
 **/
public class flatten_ {
    public Node flatten(Node head) {
        if (head==null){
            return null;
        }
        Node cur=head;
        Node next=null,last=null;
        /**
         * 需要扁平化链表:
         *  当前链表若没有子节点,那么就继续遍历下一个
         *  如果当前链表有子节点节点,那么就需要保存当前链表的下一个节点,然后将其第一个子节点作为其下一个节点,其子节点的最后一个节点最为原next的prev
         */
        for(;cur!=null;cur=cur.next){
            if (cur.child==null)continue;
            //有next
            next=cur.next;
            cur.next=cur.child;
            cur.child.prev=cur;
            //需要关注的一步就是需要把cur的child置为空
            cur.child=null;
            //last为child层的最后一个节点
            last=cur.next;
            while (last.next!=null){
                last=last.next;
            }
            last.next=next;
            if (next!=null){
                next.prev=last;
            }
        }
        return head;
    }


    private class Node{
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}


