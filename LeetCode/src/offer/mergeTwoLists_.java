package offer;

import HotOneHundred.ListNode;

/**
 * @author Dylan
 * @version 1.0
 * @date 2023/3/18 12:42
 * @description 剑指 Offer 25. 合并两个排序的链表
 **/
public class mergeTwoLists_ {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode tem1=l1;
        ListNode tem2=l2;
        ListNode res=new ListNode();
        ListNode cur=res;
        while (tem1!=null&&tem2!=null){
            if(tem1.val<tem2.val){
                cur.next=tem1;
                tem1=tem1.next;
            }else{
                cur.next=tem2;
                tem2=tem2.next;
            }
            cur=cur.next;
        }
        if(tem1==null){
            cur.next=tem2;
        }
        if(tem2==null){
            cur.next=tem1;
        }
        return res.next;
    }
}
