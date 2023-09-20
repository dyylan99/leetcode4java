package cn.dylan.ListNode;

import cn.dylan.ListNode.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/18 15:37
 * @description 142. 环形链表 II
 **/
public class detectCycle_ {
    public ListNode detectCycle(ListNode head) {
        /**
         * slow: a+n(b+c)+c
         * fast: a+m(b+c)+c
         * a+m(b+c)+c=2a+2c+2n(b+c)
         * a+c=(m-2n)(b+c)
         * a=(m-2n)(b+c)-c
         */
        if (head==null || head.next==null){
            return null;
        }
        ListNode f=head;
        ListNode s=head;
        while (f!=null&&f.next!=null){
            f=f.next.next;
            s=s.next;
            if (f==s){
                break;
            }
        }
        if (f==null || f!=s){
            return null;
        }
        f=head;
        while (f!=s){
            f=f.next;
            s=s.next;
        }
        return f;

    }
}
