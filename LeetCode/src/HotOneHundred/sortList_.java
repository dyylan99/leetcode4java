package HotOneHundred;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/7 11:17
 * @description 148. 排序链表
 **/
public class sortList_ {
    public ListNode sortList(ListNode head) {
        //return mergeSort(head);

        //使用优先队列(不符合题目要求)
        PriorityQueue<ListNode>pq=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode tem=head;
        while (tem!=null){
            pq.add(tem);
            tem=tem.next;
        }
        ListNode res=new ListNode();
        tem=res;
        while (!pq.isEmpty()){
            tem.next=pq.poll();
            tem=tem.next;
        }
        return res.next;
    }
    //归并排序
    private ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        //找出中点位置
        ListNode fast=head.next.next;ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode r,l;
        r=mergeSort(slow.next);
        //从中间断开
        slow.next=null;
        //排左边半部分
        l=mergeSort(head);
        return mergeList(l,r);
    }

    //合并两个有序链表
    private ListNode mergeList(ListNode l,ListNode r){
        ListNode tem=new ListNode(-1);
        ListNode p=tem;
        while (l!=null&&r!=null){
            if(l.val<r.val){
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
