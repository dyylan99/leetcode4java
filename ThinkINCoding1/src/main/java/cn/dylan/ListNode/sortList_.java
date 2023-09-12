package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/11 14:53
 * @description 148. 排序链表
 **/
public class sortList_ {
    //使用快速排序
    public ListNode sortList1(ListNode head) {
        if (head==null || head.next==null)return head;
        ListNode tmp=new ListNode(-1);
        tmp.next=head;
        return quickSort(tmp,null);
    }
    //带头节点的链表快速排序
    private ListNode quickSort(ListNode head, ListNode end){
        if (head==end || head.next==end || head.next.next==end){
            return head;
        }
        //将小于划分点的节点存储在临时链表中
        ListNode tmp=new ListNode(-1);
        // partition为划分点，p为链表指针，tp为临时链表指针
        ListNode partition=head.next,p=partition,tp=tmp;
        //将小于划分点的节点移动到临时链表中
        while (p.next!=end){
            if (p.next.val< partition.val){
                tp.next=p.next;
                tp=tp.next;
                p.next=p.next.next;
            }else{
                p=p.next;
            }
        }
        //合并原链表和临时链表
        tp.next=head.next;
        //将合并后的链表插入到原链表
        head.next=tmp.next;
        //不带头结点, 相当于区间是左开右闭
        quickSort(head,partition);
        quickSort(partition,end);
        return head.next;
    }
    //1 2 3 4 5
    //使用归并排序
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        //找出中点位置
        ListNode fast=head.next.next;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //此时链表的中点是slow.next
        //排右半部分
        ListNode r=sortList(slow.next);
        //从中间断开
        slow.next=null;
        //排左半部分
        ListNode l=sortList(head);
        //合并
        return mergeList(l,r);
    }
    private ListNode mergeList(ListNode l, ListNode r){
        ListNode tem=new ListNode(-1);
        ListNode p=tem;
        while (l!=null&&r!=null){
            if (l.val<r.val){
                p.next=l;
                l=l.next;
            }else{
                p.next=r;
                r=r.next;
            }
            p=p.next;
        }
        p.next=l==null?r:l;
        return tem.next;
    }
}
