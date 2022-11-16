package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/15 15:27
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 **/
public class removeNthFromEnd_ {
    public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next==null){
                return null;
            }
          ListNode cur=head;
          int length=1;
          while (cur.next!=null){
              cur=cur.next;
              length++;
          }
          //删除第n个节点就是找到第 length-n+1个元素, 并且将其删除
            cur=head;
            ListNode pre=head;
            for (int i = 0; i < length-n; i++) {
                pre=cur;
                cur=cur.next;
            }
            //删除的是第一个元素
            if(pre==cur){
                head=cur.next;
            }
            pre.next=cur.next;
            return head;

    }
}
