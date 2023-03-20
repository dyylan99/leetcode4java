package offer;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/18 12:32
 * @description TODO
 **/
public class reverseList_ {
    public ListNode reverseList(ListNode head) {
        //双指针反转链表的头结点
        if(head==null||head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode tem=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tem;
        }
        return pre;
    }
}
