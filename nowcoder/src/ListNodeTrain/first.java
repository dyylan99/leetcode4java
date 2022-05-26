package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/23 21:26
 * @description 反转链表:头结点带值,空间复杂度为O(1),时间复杂度为O(n):
 * 时间复杂度为O(n),则根据头结点依次往下找,(相对于当前表)第二个节点指向第一个,第三个指向第二个,头结点next为null
 **/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class first {

    public ListNode ReverseList(ListNode head) {
        ListNode next=null;
        ListNode pre=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        if(head==null){
            return null;
        }
        return pre;
    }


}
