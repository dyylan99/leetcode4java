package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/15 15:47
 * @description 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 160.链表相交
 **/
public class getIntersectionNode_ {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null){
            return null;
        }
        ListNode curA=headA;
        int lengthA=0;
        ListNode curB=headB;
        int lengthB=0;
        //计算两条链表的长度
        while (curA!=null){
            curA=curA.next;
            lengthA++;
        }
        while (curB!=null){
            curB=curB.next;
            lengthB++;
        }
        curA=headA;
        curB=headB;
        //计算两条链表的差值,并且让长链表指针指到差值位置
        //接下来一一比较两个链表剩下的元素
        int count=0;
        if(lengthA>lengthB){
            count=lengthA-lengthB;
            for (int i = 0; i < count; i++) {
                curA=curA.next;
            }
        }else{
            count=lengthB-lengthA;
            for (int i = 0; i < count; i++) {
                curB=curB.next;
            }
        }
        while (curA!=null&&curB!=null){
            // 注意此处直接比较指针指向的节点,不是节点的值!!!!!
            if(curA!= curB){
                curA=curA.next;
                curB=curB.next;
            }else{
                return curA;
            }
        }
        return null;
    }
}
