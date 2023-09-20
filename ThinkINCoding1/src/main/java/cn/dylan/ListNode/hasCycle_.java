package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/15 15:27
 * @description TODO
 **/
public class hasCycle_ {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null){
            return false;
        }

        ListNode f=head.next.next;
        ListNode s=head.next;
        while (f!=null && f.next!=null){
            if (f==s){
                return true;
            }
            f=f.next.next;
            s=s.next;
        }
        return false;
    }
}
