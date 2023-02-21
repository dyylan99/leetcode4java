package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/21 9:48
 * @description 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 24. 两两交换链表中的节点
 **/
public class swapPairs_ {
    public ListNode swapPairs(ListNode head){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode cur=dummyHead;
        while (cur.next!=null&&cur.next.next!=null){
            ListNode tem = cur.next;
            ListNode tem1=cur.next.next.next;
            cur.next=cur.next.next;
            cur.next.next=tem;
            cur.next.next.next=tem1;

            cur=cur.next.next;
        }
        return dummyHead.next;
    }
}
