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

    //无头结点
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode next=null;
        ListNode pre=null;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return pre;
    }
    //有头结点
    public static ListNode reveereList1(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode cur=preHead.next;
        ListNode next;
        while(cur.next!=null){
            next=cur.next;
            cur.next=next.next;
            next.next=preHead.next;
            preHead.next=next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node1=null;
        reveereList1(node1);
    }


}
