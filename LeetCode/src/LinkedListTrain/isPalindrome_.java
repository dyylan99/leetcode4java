package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/21 10:02
 * @description 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 * 234. 回文链表
 **/
public class isPalindrome_ {
    public boolean isPalindrome(ListNode head) {
        //如果为空或者只有一个节点
        if(head==null||head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode pre=head;
        while (fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        //分割两个链表
        pre.next=null;
        ListNode cur1=head;
        ListNode cur2=reverse(slow);
        while (cur1!=null){
            if(cur1.val!=cur2.val){
                return false;
            }
            //若相等,则移动两个节点
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return true;
    }

    //反转链表
   public ListNode reverse(ListNode head){
        ListNode tem=null;
        ListNode pre=null;
        while (head!=null){
            tem=head.next;
            head.next=pre;
            pre=head;
            head=tem;
        }
        return pre;
   }
}
