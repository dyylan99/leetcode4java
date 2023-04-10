package LinkedListTrain;

import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/4 18:20
 * @description TODO
 **/
public class deleteDuplicates_ {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode yummy=new ListNode(-1,head);
        ListNode cur=yummy.next;
        ListNode pre=yummy;
        while(cur!=null&&cur.next!=null){
            if(cur.val!=cur.next.val){
                pre.next=cur;
                pre=cur;
                cur=cur.next;
            }else{
                //找到第一个不同的节点
                while(cur.next != null && cur.val == cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
            }
        }
        if(cur!=null){
            pre.next=cur;
            pre=pre.next;
        }
        pre.next=null;
        return yummy.next;
    }
    @Test
    public void test(){
        ListNode head = ArrayToLinkedList.AsLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5});
        deleteDuplicates(head);
    }
}
