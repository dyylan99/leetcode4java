package Sort;

import LinkedListTrain.ArrayToLinkedList;
import LinkedListTrain.ListNode;
import org.junit.Test;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/4/8 22:46
 * @description TODO
 **/
public class mergeSortListNode {

    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        //找出终点位置
        ListNode fast=head.next.next;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode l,r;
        //排序右半部分
        r=mergeSort(slow.next);
        slow.next=null;
        l=mergeSort(head);
        return mergeList(l,r);
    }

    public ListNode mergeList(ListNode l,ListNode r){
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
    @Test
    public void test(){
        ListNode head = ArrayToLinkedList.AsLinkedList(new int[]{1, 5, 7, 3, 4, 2});
        ListNode node = mergeSort(head);

        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }

    }
}
