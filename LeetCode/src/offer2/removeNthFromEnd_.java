package offer2;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/20 14:00
 * @description 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 **/
public class removeNthFromEnd_ {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp=head;
        int length=0;
        while (tmp!=null){
            tmp=tmp.next;
            length++;
        }
        tmp=head;
        if (n==length){
            //删除头结点
            return head.next;
        }
        for (int i = 0; i < length - n; i++) {
            tmp=tmp.next;
        }

        tmp.next=tmp.next.next;
        return head;

    }
}
