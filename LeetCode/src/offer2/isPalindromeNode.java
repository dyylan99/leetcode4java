package offer2;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/24 20:07
 * @description TODO
 **/
public class isPalindromeNode {
    public boolean isPalindrome(ListNode head) {
        //只有一个节点
        if (head.next==null){
            return true;
        }
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode cur=slow.next;
        slow.next=null;
        cur = reverse(cur);
        slow=head;
        while (slow!=null){
            if (slow.val!=cur.val){
                return false;
            }
            slow=slow.next;
            cur=cur.next;
        }
        return true;
    }

    public ListNode reverse(ListNode root){
        if (root==null){
            return null;
        }
        ListNode pre=null;
        ListNode cur=root;

        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
