package offer;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/17 13:46
 * @description TODO
 **/
public class deleteNode_ {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur=head;
        //若待删除的节点是头结点
        if(cur.val==val){
            head=head.next;
        }
        while (cur!=null&&cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }
}
