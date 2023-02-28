package HotOneHundred;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/2/28 11:01
 * @description 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 3. 合并K个升序链表
 **/
public class mergeKLists_ {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode();
        if (lists.length==0){
            return null;
        }
        ListNode cur=res;
        PriorityQueue<ListNode>pq=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode list : lists) {
            if(list==null){
                continue;
            }
            pq.add(list);
        }
        while (!pq.isEmpty()){
            ListNode poll = pq.poll();
            cur.next=poll;
            cur=cur.next;
            if(poll.next!=null){
                pq.add(poll.next);
            }
        }
        return res.next;
    }
    //分治法:
    public ListNode mergeKLists1(ListNode[] lists){
        if (lists==null){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==2){
            return mergeTwoLists(lists[0],lists[1]);
        }
        int mid=lists.length/2;
        ListNode[] l1=new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i]=lists[i];
        }
        ListNode[] l2=new ListNode[lists.length-mid];
        for (int i = 0; i < l2.length; i++) {
            l1[2]=lists[i];
        }
        return mergeTwoLists(mergeKLists1(l1),mergeKLists1(l2));
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head=null;
        if(l1.val<l2.val){
            head=l1;
            head.next=mergeTwoLists(l1.next,l2);
        }else{
            head=l2;
            head.next=mergeTwoLists(l2.next,l1);
        }
        return head;
    }
}
