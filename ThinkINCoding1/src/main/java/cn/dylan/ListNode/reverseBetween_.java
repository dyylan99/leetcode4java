package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/14 19:46
 * @description 92. 反转链表 II
 **/
public class reverseBetween_ {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode rightHead=head;
        ListNode leftHead=dummy;
        for (int i = 0; i < left-1; i++) {
            leftHead=leftHead.next;
        }
        for (int i = 0; i < right; i++) {
            rightHead=rightHead.next;
        }
        leftHead.next=reverse(leftHead.next,rightHead);
        return dummy.next;
    }

    private ListNode reverse(ListNode left,ListNode right){
        // right相当于以前的null,以前翻转整个链表，自然是到尾巴，这次就到right
        ListNode pre=right;
        // 这里的left相当于以前的head，只不过这次的头并不一定是第一个节点
        ListNode cur=left;
        while (cur!=right){
            // 常规翻转链表操作，先记录后面一个结点，然后让指向前一个，然后地址赋值
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
