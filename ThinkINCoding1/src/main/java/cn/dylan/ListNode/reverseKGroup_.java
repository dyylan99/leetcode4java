package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/13 16:12
 * @description 25. K 个一组翻转链表
 **/
public class reverseKGroup_ {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,end=dummy;
        while (end.next!=null){
            for (int i = 0; i < k&&end!=null; i++) {
                end=end.next;
            }
            if (end==null){
                break;
            }

            ListNode start=pre.next;
            //保存翻转的下一位
            ListNode next=end.next;
            //断开,使得start到end这段链表就是需要翻转的
            end.next=null;
            pre.next=reverse(start);
            //原本开头的元素现在变成了最后一位元素,链接上原链表
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
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
