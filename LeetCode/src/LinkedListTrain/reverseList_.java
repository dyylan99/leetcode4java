package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/25 12:09
 * @description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 206. 反转链表
 **/
public class reverseList_ {
    public ListNode reverseList(ListNode head){
        //采用双指针的方式
        //pre记录的是每次反转节点的前一个节点,初始化为null
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return cur;
    }
}
