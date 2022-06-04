package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/3 21:37
 * @description 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 * 1->1->1->2->3->3->4
 * pre->head->
 *      cur->
 **/
public class sixteen {
    public ListNode deleteDuplicates (ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode pre=new ListNode(-1);
        pre.next=head;
        ListNode p=pre;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.val==cur.next.val){
               while(cur.next!=null&&cur.val==cur.next.val){
                   cur=cur.next;
               }
               p.next=cur.next;
               cur=cur.next;
            }else{
                p=cur;
                cur=cur.next;
            }
        }
        return pre.next;
    }
}
