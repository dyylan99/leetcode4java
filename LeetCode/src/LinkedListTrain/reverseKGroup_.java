package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/2 17:11
 * @description 25. K 个一组翻转链表
 **/
public class reverseKGroup_ {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
       ListNode dummy=new ListNode(0);
        dummy.next=head;
        //开始反转的前一个元素
        ListNode pre=dummy;
        //反转的最后一个元素
        ListNode end=dummy;

        while (end.next!=null){
            for (int i = 0; i < k&&end!=null; i++) {
                //找到反转链表的最后一个
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode start=pre.next;
            //保存下一位node

            ListNode next=end.next;
            end.next=null;
            //头元素
            pre.next=reverse(start);
            //原本第一个现在已经变成最后一个
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;

    }

    private ListNode reverse(ListNode cur){
        ListNode pre=null;
        ListNode tmp=cur;
        while (tmp!=null){
            ListNode next=tmp.next;
            tmp.next=pre;
            pre=tmp;
            tmp=next;
        }
        return pre;
    }

}
