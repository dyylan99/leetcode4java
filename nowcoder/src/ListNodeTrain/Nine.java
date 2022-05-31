package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/31 9:05
 * @description 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1-> 2-> 3-> 4  n= 2
 * 删除了链表的倒数第 n个节点之后,链表变为1->2->4
 * 题目保证n是有效的
 **/
public class Nine {
    /**
     *思路:首先找到第n个节点,再将其删除
     * 但需要考虑的是:n在第一个或者最后一个的特殊情况
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        if(head==null){
            return null;
        }

        ListNode fast=head;
        ListNode slow=head;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        /**
         * 若n恰好等于链表长度,则删除的是第一个元素
         */
      if(fast==null){
          return head.next;
      }
        /**
         * 否则:我们可以找到倒数第k-1个元素
         */
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;

        }
        slow.next=slow.next.next;
        return head;
    }
}
