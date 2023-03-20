package offer;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/18 12:29
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 **/
public class getKthFromEnd_ {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //双指针
        ListNode fast=head;
        ListNode slow=head;
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }
        while (fast != null) {
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
