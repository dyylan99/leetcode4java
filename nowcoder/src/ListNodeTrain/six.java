package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/29 10:52
 * @description 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 输入分为两部分，第一部分为链表，第二部分代表是否有环，
 * 然后将组成的head头结点传入到函数里面。
 * -1代表无环，其它的数字代表有环，
 * 这些参数解释仅仅是为了方便读者自测调试。
 * 实际在编程时读入的是链表的头节点
 **/

/**
 * 牛客网第六题:
 * 判断链表是否有环,有环返回true,无环返回FALSE
 *思路:因为是单指针链表,所以若存在环则只可能是最后一个节点指向前面的节点
 * 则我们需要找到最后一个节点的next指针,然后依次遍历
 *
 *
 * 思路2:显然上一个思路是错误的,若链表有环,则我们很难找到最后一个节点
 * 这时候需要用到快慢指针;
 * 快慢指针开始都指向头结点,但快指针一次走两步,慢指针一次走一步
 * 若有环则其一定会相遇
 *
 * 该算法复杂度
 */

public class six {
    public boolean hasCycle(ListNode head){
        boolean res=false;
        ListNode fast=head;
        ListNode slow=head;
        if(head==null){
            return false;
        }
        while (fast!=null&&slow!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return res=true;
            }
        }
        return res;
    }

}
