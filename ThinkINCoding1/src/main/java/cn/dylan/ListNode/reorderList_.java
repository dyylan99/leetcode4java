package cn.dylan.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/18 14:49
 * @description 143. 重排链表
 **/
public class reorderList_ {
    public void reorderList(ListNode head) {
       ListNode f=head;
       ListNode s=head;
        ListNode cur=head;
       while (f.next!=null && f.next.next!=null){
           s=s.next;
           f=f.next.next;
       }
       ListNode part2=s.next;
       s.next=null;
       part2=reverse(part2);
       while (part2!=null){
           ListNode next=cur.next;
           cur.next=part2;
           part2=part2.next;
           cur=cur.next;
           cur.next=next;
           cur=cur.next;
       }
    }
    public  ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
