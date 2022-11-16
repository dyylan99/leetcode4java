package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/15 15:20
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 206. 反转链表
 **/
public class reverseList_ {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
