package cn.dylan.ListNode;

import java.util.PriorityQueue;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/9/19 14:41
 * @description 23. 合并 K 个升序链表
 **/
public class mergeKLists_ {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->{
            return a.val-b.val;
        });

        for (ListNode list : lists) {
            ListNode cur=list;
            while (cur!=null){
                pq.add(cur);
                cur=cur.next;
            }
        }
        ListNode head=pq.poll();
        ListNode node=head;
        while (!pq.isEmpty()){
            node.next=pq.poll();
            if (pq.isEmpty()){
                node.next=null;
                break;
            }
            node=node.next;
        }

        return head;
    }
}
