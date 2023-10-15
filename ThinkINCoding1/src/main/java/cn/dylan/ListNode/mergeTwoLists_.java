package cn.dylan.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/10/13 16:25
 * @description 21. 合并两个有序链表
 **/
public class mergeTwoLists_ {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1==null && list2==null){
            return null;
        }
        ListNode res=new ListNode(0);
        ListNode l1=list1,l2=list2;
        ListNode cur=res;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if (l1!=null){
            cur.next=l1;
        }else{
            cur.next=l2;
        }
        return res.next;
    }
}
