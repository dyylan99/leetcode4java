package offer;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/26 13:09
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 **/
public class getIntersectionNode_ {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if(headA==null||headB==null){
           return null;
       }
       int lengthA=0,lengthB=0;
       ListNode curA=headA,curB=headB;
        while (curA!=null){
            lengthA++;
            curA=curA.next;
        }
        while (curB!=null){
            lengthB++;
            curB=curB.next;
        }
        curA=headA;
        curB=headB;
        if(lengthA>lengthB){
            for (int i = 0; i < lengthA-lengthB; i++) {
                curA=curA.next;
            }
        }else{
            for (int i = 0; i < lengthB-lengthA; i++) {
                curB=curB.next;
            }
        }
        return getSame(curA,curB);

    }

    private ListNode getSame(ListNode A,ListNode B){
        //默认A,B长度相同
        while (A!=null){
            if(A==B){
                return A;
            }else {
                A=A.next;
                B= B.next;
            }
        }
        return null;
    }
}
