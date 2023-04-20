package offer2;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/20 14:28
 * @description TODO
 **/
public class detectCycle_ {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null||head.next.next==null)
            return null;
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while (slow!=fast&&fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //此时slow和fast相遇
        slow=head;
        while (slow!=fast&&fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
