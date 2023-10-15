package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/4 19:17
 * @description TODO
 **/
public class removeNthFromEnd_ {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy=new ListNode(-1,head);
       ListNode pre=dummy;
       ListNode cur=head;
        for (int i = 0; i < n; i++) {
            cur=cur.next;
        }
        while (cur!=null){
            cur=cur.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return dummy.next;
    }
}
