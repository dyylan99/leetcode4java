package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/31 8:03
 * @description 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 *  * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *  * 思路一:第一想到的是倒转链表,然后按k返回前几个元素
 *  pre-->1-->2-->3-->4
 **/
public class eight {
    /**
     * 思路一:倒转链表,然后返回前k个元素
     */
    public ListNode reverseListNode3(ListNode pHead) {

        ListNode prehead = new ListNode(-1);
        prehead.next = pHead;
        ListNode cur = pHead;
        ListNode next ;
        while (cur != null && cur.next != null) {
            next = cur.next;
            cur.next = next.next;
            next.next = prehead.next;
            prehead.next = next;
        }
        return prehead.next;
    }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        /**
         * 第一步:倒转链表
         */
        ListNode Nodelist = reverseListNode3(pHead);
        /**
         * 第二步:取出前k个值,若链表个数没有k个,则返回空
         */
        ListNode res=new ListNode(-1);
        res.next=null;
        ListNode head=Nodelist;
        ListNode workNode=res;
        int count = 0;
        while (head!=null&&count < k) {
            workNode.next=head;
            head=head.next;
            workNode=workNode.next;
            count++;
        }
        if(count!=k){
            return res.next=null;
        }else{
        /**
         * 得到的前k个值,再进行转置
         */
        workNode.next=null;
       return reverseListNode3(res.next);

        }
        /**
         * 这种写法需要转置链表两次,而且还不简单,
         * 时间复杂度较高,显然不是一个令人满意的答案
         */
    }
    /**
     * 思路二:使用双指针,fast先走k步,然后fast与slow一起走,
     * 当fast为null时,slow所指的节点即为所求:
     *
     */

    public ListNode FindKthToTail2 (ListNode pHead, int k) {
        ListNode fast=pHead;
        ListNode slow=pHead;
        /**
         * 先走k步
         */
        while(k>0&&fast!=null){
            fast=fast.next;
            --k;
        }

        /**
         * 判断k是否大于0,若大于0则说明链表个数小于k,返回null
         */
        if(k>0){
            return null;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;

    }


}
