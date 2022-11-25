package LinkedListTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/25 10:48
 * @description 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 *
 *203. 移除链表元素
 **/
public class removeElements_ {
    //方式一:直接在原来的链表上操作
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        //虚拟头结点
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }


    public ListNode removeElements1(ListNode head, int val){
        //若head前面的节点值为val,那就直接跳过
       while (head!=null&&head.val==val){
           head=head.next;
       }
       //已经为null则提前退出
        if(head==null){
            return head;
        }
        //确定当前的head.val不为val
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }
            else{
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }
}
