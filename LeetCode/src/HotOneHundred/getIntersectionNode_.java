package HotOneHundred;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/8 11:45
 * @description TODO
 **/
public class getIntersectionNode_ {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //获得两个链表的长度
        int lenA=0,lenB=0;
        ListNode tem1=headA;
        ListNode tem2=headB;
        while (tem1!=null){
            lenA++;
            tem1=tem1.next;
        }
        while (tem2!=null){
            lenB++;
            tem2=tem2.next;
        }
        tem1=headA;
        tem2=headB;
        if(lenA>lenB){
            for (int i = 0; i < lenA-lenB; i++) {
                tem1=tem1.next;
            }
        }else{
            for (int i = 0; i < lenB-lenA; i++) {
                tem2=tem2.next;
            }
        }
        return findSameNode(tem1,tem2);
    }
    public ListNode findSameNode(ListNode a,ListNode b){
        while (a!=null&&b!=null){
            if(a==b){
                return a;
            }else{
                a=a.next;
                b=b.next;
            }
        }
        return null;
    }
}
