package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/14 19:59
 * @description 160. 相交链表
 **/
public class getIntersectionNode_ {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0,l2=0;
        ListNode a=headA,b=headB;
        while (a!=null || b!=null){
            if (a!=null){
                a=a.next;
                l1++;
            }
            if (b!=null){
                b=b.next;
                l2++;
            }
        }
        a=headA;
        b=headB;
        while (l1>l2){
            l1--;
            a=a.next;
        }
        while (l2>l1){
            l2--;
            b=b.next;
        }
        while (a!=null){
            if (a==b){
                return a;
            }
            a=a.next;
            b=b.next;
        }

        return null;
    }
}
