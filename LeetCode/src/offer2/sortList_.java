package offer2;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/19 15:09
 * @description TODO
 **/
public class sortList_ {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }

        //找到中点位置
        ListNode fast=head.next.next;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode l,r;
        r=sortList(slow.next);
        slow.next=null;
        l=sortList(head);
        return mergeList(l,r);

    }

    //合并两个有序链表
    private ListNode mergeList(ListNode l,ListNode r){
        ListNode tem=new ListNode(-1);

        ListNode p=tem;

        while (l!=null&&r!=null){
            if (l.val<r.val){
                p.next=l;
                l=l.next;
            }else {
                p.next=r;
                r=r.next;
            }
            p=p.next;
        }
        p.next=l==null?r:l;
        return tem.next;
    }
}
