package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/19 14:18
 * @description 82. 删除排序链表中的重复元素 II
 **/
public class deleteDuplicates_ {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode cur=head;
        ListNode next=head.next;
        while (next!=null){
            if (next.val!=cur.val){
                cur=cur.next;
                next=next.next;
                pre=pre.next;
            }else{
                while (next!=null&&next.val==cur.val){
                    next=next.next;
                }
                pre.next=next;
                cur=next;
                if (next==null){
                    break;
                }
                next=cur.next;
            }
        }
        return dummyHead.next;
    }
}
