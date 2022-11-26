package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/26 12:42
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 * 19. 删除链表的倒数第 N 个结点
 **/
public class removeNthFromEnd_ {
    public ListNode removeNthFromEnd(ListNode head,int n){
        //删除倒数第n个节点
        //先让快指针走n步,然后快慢指针一起走,直到快指针走到结尾,这样慢指针指向的就是删除节点的前一个节点
        ListNode preHead=new ListNode(-1,head);
        ListNode fast=preHead;
        ListNode slow=preHead;
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        //此时slow指向的就是删除节点的前一个
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return preHead.next;
    }
}
