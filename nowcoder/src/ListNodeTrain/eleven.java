package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/1 9:30
 * @description 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 空间复杂度为o(n)
 **/


public class eleven {
/**
 * 思路一:找到每个链表的最后一位,首先是反转链表,再依次进行相加,再将相加的结果反转------>最容易想到的答案
 *
 * 思路二:利用栈存放每个链表的元素,然后依次出栈,相加,组成新的链表
 */
    public ListNode addInList (ListNode head1, ListNode head2) {
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        /**
         * 第一步,反转链表  9->4->3 ----->  3->4->9
         *                  6->7 ----->  7->6
         */
        ListNode reverseHead1=reverseNode(head1);
        ListNode reverseHead2=reverseNode(head2);
        ListNode res=new ListNode(0);
        ListNode workNode=res;
        /**
         * 第二步:进行链表的相加:
         * 步骤是:
         * 维护一个进位常量,进位常量的值为两个对应链表节点的和,再将其对10取余与取整
         */
        int t=0;
        while(reverseHead1!=null||reverseHead2!=null){
           if(reverseHead1!=null){
               t+=reverseHead1.val;
               reverseHead1=reverseHead1.next;
           }
           if(reverseHead2!=null){
               t+=reverseHead2.val;
               reverseHead2=reverseHead2.next;
           }
           workNode.next=new ListNode(t%10);
           t=t/10;
           workNode=workNode.next;
        }
        if(t!=0){
            workNode.next=new ListNode(t);
        }
        /**
         * 第三步:将得到的链表相加的结果再次反转:
         */
        return reverseNode(res.next);
    }
    public ListNode reverseNode(ListNode head){
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode cur=head;
        ListNode next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
/**
 * 方法二:使用栈:
 */


}
