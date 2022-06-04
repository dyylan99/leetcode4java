package ListNodeTrain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/6/1 20:59
 * @description 给定一个节点数为n的无序单链表，对其按升序排序。
 * 要求：时间复杂度 O(nlogn)
 **/
public class twelve {
    /**
     * 利用数组:将链表中的元素放入数组中,利用数组排序
    */
    public ListNode sortInList (ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ArrayList<Integer> list=new ArrayList<>();
        ListNode work=head;
        while(work!=null){
            list.add(work.val);
            work=work.next;
        }
        Collections.sort(list);
        work=head;
        //遍历数组,依次将元素放回链表中
        for (int i = 0; i < list.size(); i++) {
            work.val=list.get(i);
            work=work.next;
        }
        return head;
    }

    /**
     * 思路二:不借助java的类库,采用归并排序的思想:
     * 分治-->将链表一直一分为二,分到不能再分为止,再将分完后的链表两两排序,排序完合并,重复操作
     */



    /**
     * 第一步,实现找到链表的中点:
     */
    /**
     * 1  2  3  4  5  6
     *
     * @param nodes
     * @return
     */
    public ListNode findMiddle(ListNode nodes){
        ListNode fast=nodes;
        ListNode slow=nodes;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    /**
     * 第二步:实现对两个升序链表的合并
     */
    public ListNode merge(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode res=new ListNode(-1);
        ListNode work=res;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                work.next=list1;
                list1=list1.next;
            }else{
                work.next=list2;
                list2=list2.next;
            }
            work=work.next;

        }
        if(list1!=null){
            work.next=list1;
        }
        if(list2!=null){
            work.next=list2;
        }
        return res.next;

    }
    /**
     * 第三步:对分治的链表排序
     */
    public ListNode sortInList1 (ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=findMiddle(head);
        ListNode midNode=mid.next;
        mid.next=null;
        ListNode node1=sortInList1(head);
        ListNode node2=sortInList1(midNode);
        return merge(node1,node2);

    }



}
